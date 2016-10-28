import com.sun.corba.se.pept.transport.OutboundConnectionCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class FileManager {

    private int mem1 = 1;
    private double mem2 = 1.2;
    private long mem3 = 1;
    private short mem4 = 1;
    private short mem5;

    private void newFile() {
        if (currentFile==null) {
            showErrorMessage("No location selected for new file.","Select Location");
            return;
        }

        if (newFilePanel==null) {
            newFilePanel = new JPanel(new BorderLayout(3,3));

            JPanel southRadio = new JPanel(new GridLayout(1,0,2,2));
            newTypeFile = new JRadioButton("File", true);
            JRadioButton newTypeDirectory = new JRadioButton("Directory");
            ButtonGroup bg = new ButtonGroup();
            bg.add(newTypeFile);
            bg.add(newTypeDirectory);
            southRadio.add( newTypeFile );
            southRadio.add( newTypeDirectory );

            name = new JTextField(15);

            newFilePanel.add( new JLabel("Name"), BorderLayout.WEST );
            newFilePanel.add( name );
            newFilePanel.add( southRadio, BorderLayout.SOUTH );
        }

        int result = JOptionPane.showConfirmDialog(
                gui,
                newFilePanel,
                "Create File",
                JOptionPane.OK_CANCEL_OPTION);
        if (result==JOptionPane.OK_OPTION) {
            try {
                boolean created;
                File parentFile = currentFile;
                if (!parentFile.isDirectory()) {
                    parentFile = parentFile.getParentFile();
                }
                File file = new File( parentFile, name.getText() );
                if (newTypeFile.isSelected()) {
                    created = file.createNewFile();
                } else {
                    created = file.mkdir();
                }
                if (created) {

                    TreePath parentPath = findTreePath(parentFile);
                    DefaultMutableTreeNode parentNode =
                            (DefaultMutableTreeNode)parentPath.getLastPathComponent();

                    if (file.isDirectory()) {
                        // add the new node..
                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(file);

                        TreePath currentPath = findTreePath(currentFile);
                        DefaultMutableTreeNode currentNode =
                                (DefaultMutableTreeNode)currentPath.getLastPathComponent();

                        treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                    }

                    showChildren(parentNode);
                } else {
                    String msg = "The file '" +
                            file +
                            "' could not be created.";
                    showErrorMessage(msg, "Create Failed");
                }
            } catch(Throwable t) {
                showThrowable(t);
            }
        }
        gui.repaint();
    }

    //    private void simpleFor() {
//        int a = 0;
//        for (int i = 0; i < 10; i++) {
//            a++;
//        }
//    }
//
//    private void simpleDo() {
//        int a = 0;
//        do {
//            a++;
//        } while (a < 10);
//    }

//    private void empty() {
//        if (1==1) {
//            return;
//        }
//    }

//    private void testEssComplexity() {
//        if (1 == 0) {
//            if (2 == 0) {
//                int a = 9;
//            }
//        }
//    }

//    private void simpleSwitch() {
//        int mmmmm = 0;
//        switch (mmmmm) {
//            case 0:
//                break;
//            case 1:
//                break;
//            default:
//                break;
//        }
//    }

//    private void simplerIf() {
//        int a = 0;
//        if (2 == 0 && 2 == 2 || 2 == 0) {
//            a = 9;
//        }
//        return 1;
//    }

    private void simpleIf() {
        int a = 0;
        int b = 10;
        if (2 == 0 && 2 == 2 || 2 == 0) {
            a = 2132;
        } else {
            b = 99;
        }
        return 1;
    }

    public void showRootFile() {
        // ensure the main files are displayed
        tree.setSelectionInterval(0,0);
    }

    private int CC() {

        mem1 = 2;
        if (2 == 0) {
            return 3;
        } else {
            if (8 == 0) {
                return 9;
            }
        }

        return 10;
    }

    private int theSleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ddd");
        Math.abs(2);
        return 2;
    }

    public String case2(int index, String string) {
        String returnString = null;
        if (index < 0) {
            throw new IndexOutOfBoundsException("exception <0 ");
        }
        if (index == 1) {
            if (string.length() < 2) {
                return string;
            }
            returnString = "returnString1";
        } else if (index == 2) {
            if (string.length() < 5) {
                return string;
            }
            returnString = "returnString2";
        } else {
            throw new IndexOutOfBoundsException("exception >2 ");
        }
        return returnString;
    }

    private int CalculateScore(int culture, String nation, boolean extend) {
        int result = 0;
        System.out.println("HEHE");
        if (culture < 0) {
            throw new RuntimeException("分数不能小于0");
        } else if (culture < 200) {
            return culture;
        } else {
            switch (nation) {
                case "汉":
                    result = 0;
                    break;
                case "蒙":
                case "回":
                case "维":
                case "藏":
                    result = 10;
                    break;
                default:
                    result = 20;
            }
        }

        if (extend) {
            result += 10;
        }
        return result + culture;

    }

    private static int nestSwitch(int c) {
        switch (c) {
            case 1:
            case 2:
                a += b;
                switch (c) {
                    case 1:
                    case 2:
                        a = 2;
                        break;
                }
                break;
            case 3:
                b += a;
                break;
            default:
                a -= b;
                break;
        }
    }

    public synchronized static void main(String... args) {
        System.out.println("456231");
        int c = 9 == 2 ? (8 == 0 ? 0 : 89) : 3;
        int b = 2 || 3;
        String sss = null;
//        if (1==1) {
//            int a = 9;
//            a = 10;
//            a = 22;
//            a--;
//            Scanner scanner = new Scanner(System.in);
        while (true) {
            int b = 0;
            int c = (1 + 88) * 23;
            Math.abs(22.3);
        }
//
//            for (int i = 0; i < 10; i++) {
//                System.out.println("this");
//                switch (i) {
//                    case 0:
//                        break;
//                    case 2:
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
    }
}