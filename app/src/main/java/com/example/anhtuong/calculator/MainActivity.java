package com.example.anhtuong.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtInput;
    private TextView txtResult;

    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;

    private Button btnClear;
    private Button btnBackSpace;

    private Button btnSum;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;

    private Button btnBracket;
    private Button btnDot;
    private Button btnNeg;
    private Button btnResult;

    private int numberOfBracketOpen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget() {
        txtInput = (TextView) findViewById(R.id.txtInput);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnNum0 = (Button) findViewById(R.id.btnNum0);
        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);
        btnNum5 = (Button) findViewById(R.id.btnNum5);
        btnNum6 = (Button) findViewById(R.id.btnNum6);
        btnNum7 = (Button) findViewById(R.id.btnNum7);
        btnNum8 = (Button) findViewById(R.id.btnNum8);
        btnNum9 = (Button) findViewById(R.id.btnNum9);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnBackSpace = (Button) findViewById(R.id.btnBackSpace);

        btnSum = (Button) findViewById(R.id.btnSum);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnBracket = (Button) findViewById(R.id.btnBracket);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnNeg = (Button) findViewById(R.id.btnNeg);
        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void setEventClickViews() {
        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnBackSpace.setOnClickListener(this);

        btnSum.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnBracket.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnNeg.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNum0:
                // TO DO
                txtInput.append("0");
                break;
            case R.id.btnNum1:
                // TO DO
                txtInput.append("1");
                break;
            case R.id.btnNum2:
                // TO DO
                txtInput.append("2");
                break;
            case R.id.btnNum3:
                // TO DO
                txtInput.append("3");
                break;
            case R.id.btnNum4:
                // TO DO
                txtInput.append("4");
                break;
            case R.id.btnNum5:
                // TO DO
                txtInput.append("5");
                break;
            case R.id.btnNum6:
                // TO DO
                txtInput.append("6");
                break;
            case R.id.btnNum7:
                // TO DO
                txtInput.append("7");
                break;
            case R.id.btnNum8:
                // TO DO
                txtInput.append("8");
                break;
            case R.id.btnNum9:
                // TO DO
                txtInput.append("9");
                break;

            case R.id.btnClear:
                // TO DO
                txtInput.setText("");
                numberOfBracketOpen = 0;
                txtResult.setText("");
                break;
            case R.id.btnBackSpace:
                // TO DO
                String numberAfterRemove =
                        deleteANumber(txtInput.getText().toString());
                txtInput.setText(numberAfterRemove);
                break;

            case R.id.btnSum:
                // TO DO
                txtInput.append("+");
                break;
            case R.id.btnSub:
                // TO DO
                txtInput.append("-");
                break;
            case R.id.btnMul:
                // TO DO
                txtInput.append("*");
                break;
            case R.id.btnDiv:
                // TO DO
                txtInput.append("/");
                break;

            case R.id.btnBracket:
                // TO DO
                String numberAfterAddBracket = bracket(txtInput.getText().toString());
                txtInput.setText(numberAfterAddBracket);
                break;
            case R.id.btnDot:
                // TO DO
                txtInput.append(".");
                break;
            case R.id.btnNeg:
                // TO DO
                break;
            case R.id.btnResult:
                // TO DO
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(txtInput.getText().toString());
                addNumber(txtInput.getText().toString());
                // Thuật toán tính toán biểu thức
                if (arrOperation.size() >= arrNumber.size() || arrOperation.size() < 1) {
                    txtResult.setText("Syntax ERROR");
                }
                else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                }
                                else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                }
                                else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                }
                                else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                }
                                else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    txtResult.setText("=" + df.format(result) + "");
                }
                break;
            default:
                break;
        }
    }

    public String deleteANumber(String number) {
        int lenght = number.length();
        String tmp = "";
        if (lenght > 0) {
            tmp = number.substring(0, lenght - 1);
            if (number.charAt(lenght - 1) == '(') {
                numberOfBracketOpen -= 1;
            } else {
                if (number.charAt(lenght - 1) == ')') {
                    numberOfBracketOpen += 1;
                }
            }
        }
        return tmp;
    }

    public String bracket(String number) {
        String tmp = number;
        int lenght = tmp.length();
        if (lenght > 0) {
            char theEndOFNumber = number.charAt(lenght - 1);
            if (theEndOFNumber == '+'
                    || theEndOFNumber == '-'
                    || theEndOFNumber == '*'
                    || theEndOFNumber == '/'
                    || theEndOFNumber == '(') {
                tmp += "(";
                numberOfBracketOpen += 1;
            } else if ((theEndOFNumber >= '0' && theEndOFNumber <= '9')
                    || theEndOFNumber == ')'
                    || theEndOFNumber == '.') {
                if (numberOfBracketOpen > 0) {
                    tmp += ")";
                    numberOfBracketOpen -= 1;
                }
            }
        } else {
            tmp += "(";
            numberOfBracketOpen += 1;
        }
        return tmp;
    }

    // Mảng chứa các phép tính +, -, *, /
    public ArrayList<String> arrOperation;
    // Mảng chứa các số
    public ArrayList<Double> arrNumber;

    // Tất cả các phép tính lưu vào mảng arOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        int len = cArray.length;
        for (int i = 0; i < len; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    // Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
