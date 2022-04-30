package action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.panel.ComponentPanel;
import com.intellij.openapi.ui.panel.ComponentPanelBuilder;
import jdk.jshell.JShell;
//import com.prueba.jar.*;

public class LegoLaucher extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Messages.showInfoMessage("Hello lego laucher", "Info");

        callCMD();
        System.out.println("Salimos de lego laucher");

//        PruebaJar pruebaJar = new PruebaJar();

        }

    public void callCMD(){
//        ProcessBuilder builder = new ProcessBuilder(
//            "cmd.exe", "/K", "dir");
//        "cmd.exe /K ", "dir");
//        "cmd/k start", "dir");
//        builder.redirectErrorStream(true);
        Process p = null;
        try {

            Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + "dir");
//            p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error en builder: " + e.toString());
        }
    }

}
