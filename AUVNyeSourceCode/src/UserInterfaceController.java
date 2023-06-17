import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class UserInterfaceController implements Initializable {

    private double s0;
    private double s1;
    private double p0;
    private double p1;

    private double eps0;
    private double eps2;

    private double oldEps;
    private double sharesBefore;
    private double sharesAfter;
    
    private static final DecimalFormat decfor = new DecimalFormat("0.000");

    @FXML
    private Hyperlink terpHyperLink;
    @FXML
    private Hyperlink dilutedEpsHyperLink;
    @FXML
    private TextField s0Field;
    @FXML
    private TextField s1Field;
    @FXML
    private TextField p0Field;
    @FXML
    private TextField p1Field;
    @FXML
    private TextField resultFieldTERP;
    @FXML
    private Button calculateTERPBtn;
    @FXML
    private AnchorPane terpPane;

    @FXML
    private TextField eps0Field;
    @FXML
    private TextField eps2Field;
    @FXML
    private TextField resultFieldDEPS;
    @FXML
    private Button calculateDEPSBtn;
    @FXML
    private AnchorPane depsPane;
    
    @FXML
    private TextField oldEpsField;
    @FXML
    private TextField sharesBeforeField;
    @FXML
    private TextField sharesAfterField;
    @FXML
    private TextField resultFieldNewEPS;
    @FXML
    private AnchorPane nepsPane;
    @FXML
    private Button calculateNewEPSBtn;
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        terpHyperLink.setOnMouseClicked(mouseEvent -> terpLink());

        dilutedEpsHyperLink.setOnMouseClicked(mouseEvent -> depsLink());
        
        calculateTERPBtn.setOnAction(action -> calculateTERP());

        calculateDEPSBtn.setOnAction(action -> caclulateDEPS());

        calculateNewEPSBtn.setOnAction(action -> calculateNEPS());

        depsPane.addEventHandler(KeyEvent.KEY_PRESSED, this::keyFireDEPS);

        terpPane.addEventHandler(KeyEvent.KEY_PRESSED, this::keyFireTERP);

        nepsPane.addEventHandler(KeyEvent.KEY_PRESSED, this::keyfireNEPS);
    }


    private void keyfireNEPS(KeyEvent ev) {
        if (ev.getCode() == KeyCode.ENTER) {
            calculateNewEPSBtn.fire();
            ev.consume(); 
        }
    }


    private void keyFireTERP(KeyEvent ev) {
        if (ev.getCode() == KeyCode.ENTER) {
            calculateTERPBtn.fire();
            ev.consume(); 
        }
    }


    private void keyFireDEPS(KeyEvent ev) {
        if (ev.getCode() == KeyCode.ENTER) {
            calculateDEPSBtn.fire();
            ev.consume();
        }
    }


    private void calculateNEPS() {
        try {
            oldEps = Double.parseDouble(oldEpsField.getText());
            sharesBefore = Double.parseDouble(sharesBeforeField.getText());
            sharesAfter = Double.parseDouble(sharesAfterField.getText());
        } catch (Exception e) {
            resultFieldNewEPS.setText("ERROR");
        }
        double result = (oldEps * (sharesBefore*1000)) / (sharesAfter*1000);
        String resultString = decfor.format(result);
        resultFieldNewEPS.setText(resultString);
        StringSelection stringSelection = new StringSelection(resultString);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


    private void caclulateDEPS() {
        try {
            eps0 = Double.parseDouble(eps0Field.getText());
            eps2 = Double.parseDouble(eps2Field.getText());
        } catch (Exception e) {
            resultFieldDEPS.setText("ERROR");
        }
        double result = ((eps0-eps2) / (eps0*2));
        String resultString = decfor.format(result);
        resultFieldDEPS.setText(resultString);
        StringSelection stringSelection = new StringSelection(resultString);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


    private void calculateTERP() {
        try {
            s0 = Double.parseDouble(s0Field.getText());
            s1 = Double.parseDouble(s1Field.getText());
            p0 = Double.parseDouble(p0Field.getText());
            p1 = Double.parseDouble(p1Field.getText());
        } catch (Exception e) {
            resultFieldTERP.setText("ERROR");
        }
        double result = ((s0*1000) * p0 + (s1*1000) * p1) / (s0 + s1);
        String resultString = decfor.format(result);
        resultFieldTERP.setText(resultString);
        StringSelection stringSelection = new StringSelection(resultString);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


    private void depsLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.investopedia.com/terms/d/dilutedeps.asp"));
        } catch (IOException e) {
            System.out.println("Page not found");
        } catch (URISyntaxException e) {
            System.out.println("Page not found");
        }
    }


    private void terpLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.investopedia.com/terms/t/theoreticalexrightsprice.asp"));
        } catch (IOException | URISyntaxException e) {
            System.out.println("Page not found");
        } 
    }

    
}

    

