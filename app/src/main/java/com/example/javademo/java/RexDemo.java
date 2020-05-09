package com.example.javademo.java;

import java.security.Policy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class RexDemo {


    public static void main(String[] args) {

//        test();

//        test2();

//        test3();

//        test4();

//        test5();

//        test6();

//        test7();

        test8();

    }

    private static void test8() {
        String s = "Here's a block of text to use as input to\n" +
                "    the regular expression matcher. Note that we'll\n" +
                "    first extract the block of text by looking for\n" +
                "    the special delimiters, then process the\n" +
                "    extracted block.";
        // Match the specially commented block of text above:
        Matcher mInput =
                Pattern.compile("\\*!(.*)!\\*", Pattern.DOTALL)
                        .matcher(s);
        if(mInput.find()){
            s = mInput.group(1); // Captured by parentheses
            out.println(s);
        }
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
//        out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while(m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
//        out.println(sbuf);
    }

    public static String input =
            "As long as there is injustice, whenever a\n" +
                    "Targathian baby cries out, wherever a distress\n" +
                    "signal sounds among the stars ... We'll be there.\n" +
                    "This fine ship, and this fine crew ...\n" +
                    "Never give up! Never surrender!";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                out.println(regex);
                regexPrinted = true;
            }
            out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() '" + m.group() +
                    "' start = " + m.start() + " end = " + m.end());
        if (m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = "
                    + m.start() + " end = " + m.end());
        if (m.matches()) // No reset() necessary
            d.display("matches() start = "
                    + m.start() + " end = " + m.end());
    }
    private static void test7() {
        for (String in : input.split("\n")) {
            out.println("input : " + in);
            for(String regex : new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"})
                examine(in, regex);
        }

    }

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    private static void test6() {

        Matcher m = // (字符)空格（（字符）空格（字符））
                Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                        .matcher(POEM);
        while (m.find()) {
            out.println(m.group());
        }

//        while (m.find()) {
////            for (int j = 0; j <= m.groupCount(); j++)
//                System.out.println("[" + m.group(1) + "]");
//            System.out.println();
//        }
    }

    private static void test5() {
        String str = "Everying is full of the linnet wings";

        Matcher matcher = Pattern.compile("\\w+").matcher(str);

        while (matcher.find()) {

            for (int i = 0; i <= matcher.groupCount(); i++) {
                out.println(" " + matcher.group());
            }

        }

    }

    private static String[] args = {"abcabccabcdefabc", "abc+", "(abc)+", "(abc){2,}"};

    private static void test4() {

//        out.println("Input :\"" + args[0] + "\"");

        for (String arg : args) {
//            out.println("Regular expression : \"" + arg + "\"");
            out.println("--------------------------------------");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + " - " + (m.end() - 1));
            }
        }

    }

    private static void test3() {
        Pattern mp = Pattern.compile("\\d+");

        String[] str = mp.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        String[] split = "我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com".split("\\d+");
//        out.println(split[0] + " " + split[1] + " " + split[2]);
//        boolean matches = Pattern.matches("\\d+", "344e44");
//        out.println(matches);

        Matcher matcher = mp.matcher("helloworld344");
        Boolean pattern = matcher.lookingAt();

        Matcher matcher1 = mp.matcher("344helloworld");
        Boolean pattern1 = matcher1.lookingAt();

//        out.println(pattern + " " + pattern1);

    }

    private static void test2() {


        final String regex = "(\\w+)@(\\w+)\\.(\\w+)";
        final String string = "somebody@163.com\n"
                + "somebo@163.com\n"
                + "some@163.com";

        final String subst = "*@$1.$2";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);

//        System.out.println("替换结果: " + result);

        String reg = "\\(?0\\d{2}[) -]?\\d{8}";
        String rex = "\\(?0\\d{2}[) -]?\\d{8}";


        out.println("(010)55859762".matches(reg));
    }

    private static void test() {
//        out.println("-1234".matches("-?\\d+"));

        String reg = "^[a-z0-9_-]{3,15}$";

//        out.println("12a".matches(reg));
//        out.println("1a".matches(reg));

        String reg2 = "[1-9][0-9]*";
//        out.println("5000".matches(reg2));

        String str = "colors";
        String str2 = "colours";
        String str3 = "colour";
        String reg3 = "colou?rs";

//        out.println(str.matches(reg3));
//        out.println(str2.matches(reg3));
//        out.println(str3.matches(reg3));
        String reg4 = "/d+/d{10}";
//        out.println("15700165675".matches(reg3));

        // runoo+b，可以匹配 runoob、runooob、runoooooob 等，+ 号代表前面的字符必须至少出现一次（1次或多次）。
        String reg5 = "runao\\*b";
//        out.println("runao*b".matches(reg5));
//        out.println("runaob".matches(reg5));
//        out.println("runaooob".matches(reg5));

        String reg6 = "1[0-9]{10}";
//        out.println("15700166565".matches(reg6));

        String reg7 = "<.*?>";
//        out.println("<h1>RUNOOB-菜鸟教程</h1>".matches(reg7));
        String Str = "Hello , World .";
        String pattern = "(\\w)(\\s+)([.,])";
        /**
         *  String Str = "2008-12-31";
         *  String pattern = "(\\d{4})-(\\d{2}-(\\d\\d))";
         */
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        System.out.println(Str.replaceAll(pattern, "$0")); // Hello , World .
        // $1 匹配 `(\w)` 结果为 `o` 和 `d`
        System.out.println(Str.replaceAll(pattern, "$1")); // Hello World

        // $2 匹配 `(\s+)` 结果为 `空格` 和 `空格`
        System.out.println(Str.replaceAll(pattern, "$2")); // Hell  Worl

        // $3 匹配 `([.,])` 结果为 `,` 和 `.`
        System.out.println(Str.replaceAll(pattern, "$3")); // Hell, Worl.


    }

    public static String getId(String url) {
        Pattern pattern = Pattern.compile("^https?://.+[:\\d+]?+/p/(\\d+)\\??.+$");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(1);
    }

}
