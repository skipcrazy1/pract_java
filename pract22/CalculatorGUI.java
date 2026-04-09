package pract22;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalculatorGUI {

    // ===================== MODEL =====================
    static class CalculatorModel {

        public double evalInfix(String expr) {
            if (expr == null || expr.trim().isEmpty()) {
                throw new IllegalArgumentException("Пустое выражение");
            }
            List<String> tokens = tokenize(expr);
            validateExpression(tokens);
            List<String> rpn = toRpn(tokens);
            return evalRpn(rpn);
        }

        // --- tokenize ---
        private List<String> tokenize(String s) {
            List<String> out = new ArrayList<>();
            StringBuilder num = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isWhitespace(c)) continue;

                if (Character.isDigit(c) || c == '.') {
                    num.append(c);
                    continue;
                }

                // flush number
                if (num.length() > 0) {
                    out.add(num.toString());
                    num.setLength(0);
                }

                // unary minus support: if '-' and (start or after '(' or operator) -> attach to number
                if (c == '-') {
                    String prev = out.isEmpty() ? null : out.get(out.size() - 1);
                    boolean unary = (prev == null) || prev.equals("(") || isOp(prev);
                    if (unary) {
                        num.append('-');
                        continue;
                    }
                }

                if ("()+-*/".indexOf(c) >= 0) {
                    out.add(String.valueOf(c));
                } else if (c == 'x' || c == 'X' || c == '×') {
                    out.add("*");
                } else if (c == '÷') {
                    out.add("/");
                } else {
                    throw new IllegalArgumentException("Недопустимый символ: '" + c + "'");
                }
            }

            if (num.length() > 0) out.add(num.toString());
            return out;
        }

        // --- validate expression ---
        private void validateExpression(List<String> tokens) {
            if (tokens.isEmpty()) {
                throw new IllegalArgumentException("Пустое выражение");
            }

            int parenCount = 0;
            boolean lastWasOp = true; // start expecting number or '(' or unary minus
            boolean lastWasNumber = false;
            boolean expectNumber = true;

            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);
                boolean isNum = isNumber(token);
                boolean isOperator = isOp(token);
                boolean isOpenParen = token.equals("(");
                boolean isCloseParen = token.equals(")");

                // Check for consecutive operators
                if (isOperator && lastWasOp && !token.equals("-")) {
                    throw new IllegalArgumentException("Два оператора подряд: " + tokens.get(i-1) + " " + token);
                }

                // Check for consecutive numbers
                if (isNum && lastWasNumber) {
                    throw new IllegalArgumentException("Два числа подряд без оператора");
                }

                // Check for invalid decimal points
                if (isNum) {
                    String num = token;
                    // Проверка на несколько точек в числе
                    int dotCount = 0;
                    for (int j = 0; j < num.length(); j++) {
                        if (num.charAt(j) == '.') dotCount++;
                    }
                    if (dotCount > 1) {
                        throw new IllegalArgumentException("Неверное число: несколько точек в " + num);
                    }

                    // Проверка на числа вида ".5" или "5."
                    if (num.startsWith(".") && num.length() == 1) {
                        throw new IllegalArgumentException("Неверное число: только точка");
                    }
                    if (num.endsWith(".")) {
                        throw new IllegalArgumentException("Неверное число: точка в конце " + num);
                    }
                }

                // Check parentheses
                if (isOpenParen) {
                    parenCount++;
                    // После '(' может быть число, унарный минус или '('
                    expectNumber = true;
                } else if (isCloseParen) {
                    parenCount--;
                    if (parenCount < 0) {
                        throw new IllegalArgumentException("Несбалансированные скобки: лишняя ')'");
                    }
                    // После ')' должен быть оператор или ')'
                    expectNumber = false;
                }

                lastWasOp = isOperator || isOpenParen;
                lastWasNumber = isNum;

                // После оператора ожидаем число или '('
                if (isOperator && !token.equals("-")) {
                    expectNumber = true;
                }
            }

            if (parenCount != 0) {
                throw new IllegalArgumentException("Несбалансированные скобки");
            }

            // Последний токен не должен быть оператором (кроме унарного минуса)
            String lastToken = tokens.get(tokens.size() - 1);
            if (isOp(lastToken) && !lastToken.equals("-")) {
                throw new IllegalArgumentException("Выражение не может заканчиваться оператором: " + lastToken);
            }
        }

        // --- shunting-yard to RPN ---
        private List<String> toRpn(List<String> tokens) {
            List<String> output = new ArrayList<>();
            Deque<String> ops = new ArrayDeque<>();

            for (String t : tokens) {
                if (isNumber(t)) {
                    output.add(t);
                } else if (isOp(t)) {
                    while (!ops.isEmpty() && isOp(ops.peek())
                            && (prec(ops.peek()) >= prec(t))) {
                        output.add(ops.pop());
                    }
                    ops.push(t);
                } else if (t.equals("(")) {
                    ops.push(t);
                } else if (t.equals(")")) {
                    while (!ops.isEmpty() && !ops.peek().equals("(")) {
                        output.add(ops.pop());
                    }
                    if (ops.isEmpty() || !ops.peek().equals("(")) {
                        throw new IllegalArgumentException("Скобки не сбалансированы");
                    }
                    ops.pop(); // '('
                } else {
                    throw new IllegalArgumentException("Неизвестный токен: " + t);
                }
            }

            while (!ops.isEmpty()) {
                String op = ops.pop();
                if (op.equals("(") || op.equals(")")) throw new IllegalArgumentException("Скобки не сбалансированы");
                output.add(op);
            }
            return output;
        }

        // --- eval RPN with safety ---
        private double evalRpn(List<String> rpn) {
            Deque<Double> st = new ArrayDeque<>();
            for (String t : rpn) {
                if (isNumber(t)) {
                    st.push(Double.parseDouble(t));
                } else if (isOp(t)) {
                    if (st.size() < 2) {
                        throw new IllegalStateException("Невозможно выполнить POP для пустого стека");
                    }
                    double b = st.pop();
                    double a = st.pop();
                    double r = switch (t) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> {
                            if (b == 0.0) throw new ArithmeticException("Деление на ноль");
                            yield a / b;
                        }
                        default -> throw new IllegalArgumentException("Неизвестный оператор: " + t);
                    };
                    st.push(r);
                } else {
                    throw new IllegalArgumentException("Неизвестный токен: " + t);
                }
            }
            if (st.size() != 1) throw new IllegalStateException("Некорректное выражение");
            return st.pop();
        }

        private boolean isNumber(String t) {
            if (t == null || t.isEmpty()) return false;

            // Проверка на унарный минус
            if (t.startsWith("-") && t.length() > 1) {
                t = t.substring(1);
            }

            // Проверка на наличие только одной точки
            boolean hasDot = false;
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (c == '.') {
                    if (hasDot) return false; // больше одной точки
                    hasDot = true;
                } else if (!Character.isDigit(c)) {
                    return false;
                }
            }

            // Проверка на числа типа ".5" или "5."
            if (t.equals(".") || t.startsWith(".") || t.endsWith(".")) {
                return false;
            }

            try {
                Double.parseDouble(t);
                return true;
            } catch (Exception ignored) {
                return false;
            }
        }

        private boolean isOp(String t) {
            return "+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t);
        }

        private int prec(String op) {
            return (op.equals("*") || op.equals("/")) ? 2 : 1;
        }
    }

    // ===================== VIEW =====================
    static class CalculatorView extends JFrame {
        private final JTextField display = new JTextField();
        private final DefaultListModel<String> historyModel = new DefaultListModel<>();
        private final JList<String> historyList = new JList<>(historyModel);
        private final JLabel status = new JLabel("Готово");

        private final JButton btnC = mkButton("C");
        private final JButton btnDot = mkButton(".");
        private final JButton btnBack = mkButton("⌫");

        private final JButton[] digits = new JButton[10];

        private final JButton btnPlus = mkButton("+");
        private final JButton btnMinus = mkButton("-");
        private final JButton btnMul = mkButton("×");
        private final JButton btnDiv = mkButton("÷");
        private final JButton btnLPar = mkButton("(");
        private final JButton btnRPar = mkButton(")");
        private final JButton btnEq = mkButton("=");

        CalculatorView() {
            super("Calculator 22_2 (MVC)");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // nicer look if available
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}

            display.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
            display.setHorizontalAlignment(SwingConstants.RIGHT);
            display.setEditable(false);
            display.setBorder(new EmptyBorder(10, 10, 10, 10));
            display.setText("0");

            historyList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
            JScrollPane historyPane = new JScrollPane(historyList);
            historyPane.setPreferredSize(new Dimension(320, 0));

            status.setBorder(new EmptyBorder(6, 10, 6, 10));

            JPanel left = new JPanel(new BorderLayout(10, 10));
            left.setBorder(new EmptyBorder(10, 10, 10, 10));

            left.add(display, BorderLayout.NORTH);
            left.add(buildButtonsPanel(), BorderLayout.CENTER);
            left.add(status, BorderLayout.SOUTH);

            JPanel root = new JPanel(new BorderLayout(10, 10));
            root.add(left, BorderLayout.CENTER);
            root.add(historyPane, BorderLayout.EAST);

            setContentPane(root);
            setMinimumSize(new Dimension(900, 480));
            setLocationRelativeTo(null);
        }

        private JPanel buildButtonsPanel() {
            // top row: C . Backspace
            JPanel topRow = new JPanel(new GridLayout(1, 3, 8, 8));
            topRow.add(btnC);
            topRow.add(btnDot);
            topRow.add(btnBack);

            // main grid like screenshot: 4 cols
            JPanel grid = new JPanel(new GridLayout(4, 4, 8, 8));

            for (int i = 0; i <= 9; i++) digits[i] = mkButton(Integer.toString(i));

            // Row 1: 7 8 9 +
            grid.add(digits[7]); grid.add(digits[8]); grid.add(digits[9]); grid.add(btnPlus);
            // Row 2: 4 5 6 -
            grid.add(digits[4]); grid.add(digits[5]); grid.add(digits[6]); grid.add(btnMinus);
            // Row 3: 1 2 3 ×
            grid.add(digits[1]); grid.add(digits[2]); grid.add(digits[3]); grid.add(btnMul);
            // Row 4: ( 0 ) ÷
            grid.add(btnLPar); grid.add(digits[0]); grid.add(btnRPar); grid.add(btnDiv);

            JPanel bottomEq = new JPanel(new GridLayout(1, 1, 8, 8));
            btnEq.setFont(btnEq.getFont().deriveFont(Font.BOLD, 18f));
            bottomEq.add(btnEq);

            JPanel all = new JPanel(new BorderLayout(8, 8));
            all.add(topRow, BorderLayout.NORTH);
            all.add(grid, BorderLayout.CENTER);
            all.add(bottomEq, BorderLayout.SOUTH);
            return all;
        }

        private JButton mkButton(String text) {
            JButton b = new JButton(text);
            b.setFocusPainted(false);
            b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
            return b;
        }

        // view API
        void setDisplay(String s) { display.setText(s); }
        String getDisplay() { return display.getText(); }

        void setStatusOk(String s) {
            status.setForeground(new Color(0, 102, 0));
            status.setText(s);
        }

        void setStatusErr(String s) {
            status.setForeground(Color.RED);
            status.setText("Ошибка: " + s);
        }

        void addHistory(String line) { historyModel.add(0, line); }

        // wiring
        void onDigit(int d, ActionListener l) { digits[d].addActionListener(l); }
        void onPlus(ActionListener l) { btnPlus.addActionListener(l); }
        void onMinus(ActionListener l) { btnMinus.addActionListener(l); }
        void onMul(ActionListener l) { btnMul.addActionListener(l); }
        void onDiv(ActionListener l) { btnDiv.addActionListener(l); }
        void onDot(ActionListener l) { btnDot.addActionListener(l); }
        void onLPar(ActionListener l) { btnLPar.addActionListener(l); }
        void onRPar(ActionListener l) { btnRPar.addActionListener(l); }
        void onBack(ActionListener l) { btnBack.addActionListener(l); }
        void onClear(ActionListener l) { btnC.addActionListener(l); }
        void onEquals(ActionListener l) { btnEq.addActionListener(l); }
    }

    // ===================== CONTROLLER =====================
    static class CalculatorController {
        private final CalculatorModel model;
        private final CalculatorView view;
        private boolean newCalculation = true;

        CalculatorController(CalculatorModel model, CalculatorView view) {
            this.model = model;
            this.view = view;

            for (int d = 0; d <= 9; d++) {
                int dd = d;
                view.onDigit(d, e -> appendDigit(dd));
            }

            view.onPlus(e -> appendOperator(" + "));
            view.onMinus(e -> appendOperator(" - "));
            view.onMul(e -> appendOperator(" × "));
            view.onDiv(e -> appendOperator(" ÷ "));
            view.onDot(e -> appendDot());
            view.onLPar(e -> appendParenthesis("("));
            view.onRPar(e -> appendParenthesis(")"));
            view.onBack(e -> backspace());
            view.onClear(e -> clear());
            view.onEquals(e -> eval());
        }

        private void clear() {
            view.setDisplay("0");
            view.setStatusOk("Очищено");
            newCalculation = true;
        }

        private void appendDigit(int digit) {
            String current = view.getDisplay();

            if (newCalculation || current.equals("0")) {
                view.setDisplay(String.valueOf(digit));
                newCalculation = false;
            } else {
                // Проверка на попытку добавить цифру после закрывающей скобки
                if (current.endsWith(")")) {
                    view.setStatusErr("После ')' должен быть оператор");
                    return;
                }
                view.setDisplay(current + digit);
            }
            view.setStatusOk("Ввод...");
        }

        private void appendOperator(String op) {
            String current = view.getDisplay();

            // Если новый расчет, начинаем с 0
            if (newCalculation) {
                view.setDisplay("0" + op);
                newCalculation = false;
            } else {
                // Заменяем последний оператор, если он есть
                String trimmed = current.trim();
                if (trimmed.isEmpty() || isOperator(trimmed.charAt(trimmed.length() - 1))) {
                    // Удаляем последний оператор
                    current = removeLastOperator(current);
                }
                view.setDisplay(current + op);
            }
            view.setStatusOk("Ввод...");
        }

        private void appendDot() {
            String current = view.getDisplay();

            // Если новый расчет или 0
            if (newCalculation || current.equals("0")) {
                view.setDisplay("0.");
                newCalculation = false;
            } else {
                // Проверяем, есть ли уже точка в последнем числе
                String[] parts = current.split("[+\\-×÷\\s()]+");
                String lastNumber = parts[parts.length - 1];

                if (lastNumber.contains(".")) {
                    view.setStatusErr("В числе уже есть точка");
                    return;
                }

                // Проверяем, что предыдущий символ - цифра или скобка
                char lastChar = current.trim().charAt(current.trim().length() - 1);
                if (!Character.isDigit(lastChar) && lastChar != ')') {
                    view.setStatusErr("Точка может быть только после цифры");
                    return;
                }

                view.setDisplay(current + ".");
            }
            view.setStatusOk("Ввод...");
        }

        private void appendParenthesis(String paren) {
            String current = view.getDisplay();

            if (newCalculation || current.equals("0")) {
                if (paren.equals(")")) {
                    view.setStatusErr("Нельзя начинать с закрывающей скобки");
                    return;
                }
                view.setDisplay(paren);
                newCalculation = false;
            } else {
                // Проверки для закрывающей скобки
                if (paren.equals(")")) {
                    long openCount = current.chars().filter(ch -> ch == '(').count();
                    long closeCount = current.chars().filter(ch -> ch == ')').count();

                    if (closeCount >= openCount) {
                        view.setStatusErr("Несбалансированные скобки");
                        return;
                    }

                    // Проверяем, что перед ')' нет оператора
                    char lastChar = current.trim().charAt(current.trim().length() - 1);
                    if (isOperator(lastChar) || lastChar == '(') {
                        view.setStatusErr("Перед ')' не может быть оператора или '('");
                        return;
                    }
                }

                // Для открывающей скобки: проверяем, что перед ней оператор или '('
                if (paren.equals("(") && !current.equals("0")) {
                    char lastChar = current.trim().charAt(current.trim().length() - 1);
                    if (Character.isDigit(lastChar) || lastChar == ')') {
                        view.setStatusErr("Перед '(' должен быть оператор");
                        return;
                    }
                }

                view.setDisplay(current + paren);
            }
            view.setStatusOk("Ввод...");
        }

        private void backspace() {
            String current = view.getDisplay();
            if (current == null || current.isEmpty() || current.equals("0")) return;

            // Удаляем один символ
            if (current.length() == 1) {
                view.setDisplay("0");
                newCalculation = true;
            } else {
                // Удаляем последний символ и очищаем пробелы в конце
                String newText = current.substring(0, current.length() - 1);
                // Удаляем пробелы в конце, но не все
                while (newText.endsWith(" ") && newText.length() > 1) {
                    newText = newText.substring(0, newText.length() - 1);
                }
                view.setDisplay(newText);
            }
            view.setStatusOk("Удален символ");
        }

        private void eval() {
            String expr = view.getDisplay();
            try {
                // Проверяем пустое выражение
                if (expr.trim().isEmpty() || expr.equals("0")) {
                    view.setStatusErr("Нет выражения для вычисления");
                    return;
                }

                // Проверяем незавершенное выражение
                char lastChar = expr.trim().charAt(expr.trim().length() - 1);
                if (isOperator(lastChar) || lastChar == '(') {
                    view.setStatusErr("Незавершенное выражение");
                    return;
                }

                // Проверяем баланс скобок
                long openCount = expr.chars().filter(ch -> ch == '(').count();
                long closeCount = expr.chars().filter(ch -> ch == ')').count();
                if (openCount != closeCount) {
                    view.setStatusErr("Несбалансированные скобки");
                    return;
                }

                double res = model.evalInfix(expr.replace("×", "*").replace("÷", "/"));
                String out = formatDouble(res);
                view.addHistory(expr + " = " + out);
                view.setDisplay(out);
                view.setStatusOk("Результат: " + out);
                newCalculation = true;
            } catch (Exception ex) {
                view.setStatusErr(ex.getMessage());
            }
        }

        private String formatDouble(double x) {
            // Убираем лишние нули после точки
            if (Math.abs(x - Math.rint(x)) < 1e-12) {
                return String.format("%.0f", x);
            }
            // Ограничиваем количество знаков после запятой
            String str = String.format("%.10f", x).replace(",", ".");
            // Убираем trailing zeros
            str = str.replaceAll("0*$", "");
            str = str.replaceAll("\\.$", "");
            return str;
        }

        private boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '×' || c == '÷' || c == '*' || c == '/';
        }

        private String removeLastOperator(String str) {
            str = str.trim();
            while (str.length() > 0 && (str.endsWith(" ") || isOperator(str.charAt(str.length() - 1)))) {
                str = str.substring(0, str.length() - 1).trim();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            new CalculatorController(model, view);
            view.setVisible(true);
        });
    }
}