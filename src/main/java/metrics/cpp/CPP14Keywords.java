package metrics.cpp;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class CPP14Keywords {
    private static String[] keywords = new String[]{"auto", "break", "case", "char", "const", "continue", "default", "do", "double", "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register", "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned", "void", "volatile", "while", "asm", "dynamic_cast", "namespace", "reinterpret_cast", "try", "bool", "explicit", "new", "static_cast", "typeid", "catch", "false", "operator", "template", "typename", "class", "friend", "private", "this", "using", "const_cast", "inline", "public", "throw", "virtual", "delete", "mutable", "protected", "true", "wchar_t", "and", "bitand", "compl", "not_eq", "or_eq", "xor_eq", "and_eq", "bitor", "not", "or", "xor"};

    private CPP14Keywords() {
    }

    public static int size() {
        return keywords.length;
    }

    public static boolean isKeyword(String keyword) {
        boolean result = false;

        for(int i = 0; i < size(); ++i) {
            if(keywords[i].equals(keyword)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
