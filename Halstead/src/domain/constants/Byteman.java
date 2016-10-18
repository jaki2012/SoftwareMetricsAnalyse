package domain.constants;


public class Byteman {
	
	public static final String ENTERING_METHOD = "Entering in method ";
	public static final String EXITING_METHOD = "Exiting method ";
	public static final String SCRIPT_DIR = System.getProperty("java.io.tmpdir") +"script";
	public static final String SCRIPT_FILE = "rules.btm";
	public static final String OUTPUT_FILE = "output.txt";
	public static final String HELPER_LOCATIO = "domain.tests.instrument.HelperClass";
}
