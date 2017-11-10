package example;

import com.nobigsoftware.dfalex.*;

public class StringMatcherExample extends TestBase {

    public static void main(String[] args)
    {
        DfaState<Integer> dfa;
        {
            DfaBuilder<Integer> builder = new DfaBuilder<>();
            builder.addPattern(Pattern.matchI("法轮功"), 1);
            builder.addPattern(Pattern.matchI("法轮大法好"), 2);
            dfa = builder.build(null);
        }
        StringMatcher matcher = new StringMatcher("中国禁止修炼法轮功之后就没有人说法轮大法好了");
        Integer result = matcher.findNext(dfa);
        while (null != result) {
            System.out.println("result: " + result);
            System.out.println("lastMatch: " + matcher.getLastMatch());
            System.out.println("lastMatchStart: " + matcher.getLastMatchStart());
            System.out.println("lastMatchEnd: " + matcher.getLastMatchEnd());
            result = matcher.findNext(dfa);
        }
    }
}
