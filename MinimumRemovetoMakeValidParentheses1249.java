package leetcode;

import java.util.Vector;

public class MinimumRemovetoMakeValidParentheses1249 {

    public void MinimumRemovetoMakeValidParentheses1249() {
        String s = "lee(t(c)o)de)";
        StringBuffer sText = new StringBuffer(s);
        Vector<ParenthesesPosition> vList = new Vector();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                vList.add(new ParenthesesPosition('(', i));
            } else if (s.charAt(i) == ')' && vList.size() != 0 && vList.get(vList.size() - 1).getValue() == '(') {
                vList.remove(vList.size() - 1);
            } else if (s.charAt(i) == ')') {
                vList.add(new ParenthesesPosition(')', i));
            }
        }
        for (int i = vList.size() - 1; i >= 0; i--) {
            sText.deleteCharAt(vList.get(i).getPosition());
        }
        System.out.println(sText.toString());
    }

    public class ParenthesesPosition {

        public char cValue;
        public int iPosition;

        public ParenthesesPosition(char cvalue, int iposition) {
            cValue = cvalue;
            iPosition = iposition;
        }

        public char getValue() {
            return cValue;
        }

        public int getPosition() {
            return iPosition;
        }
    }
}
