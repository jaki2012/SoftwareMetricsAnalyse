package domain.utils;

import org.antlr.v4.runtime.ANTLRInputStream;

/**
 * Project: Halstead
 * Package: domain.utils
 * Author:  Novemser
 * 2016/10/22
 */
public class ANTLRModuleStream extends ANTLRInputStream {

    public ANTLRModuleStream(char[] input) {
        loadModule(input);
    }

    private void loadModule(char[] input) {
        data = input;
        n = data.length;
    }
}
