package chap1.basic_program_model;

public class PrintFormat {

    public static void main(String[] args) {
        //用上科学计数法后再保留4位小数，宽度14，左空格补齐
        System.out.printf("%14.4e\n", 1595.1680010754388);
        System.out.printf("%14.4e\n", 1595.2680);
    }
}
