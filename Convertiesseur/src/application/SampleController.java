package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable
{

    @FXML
    private TabPane monPane;

    @FXML
    private Button btnMass;

    @FXML
    private Button btnLongeur;

    @FXML
    private Button btnVolume;
    
    @FXML
    private TextField txtM2;

    @FXML
    private TextField txtM1;

    @FXML
    private ComboBox<String> cboM2;

    @FXML
    private ComboBox<String> cboM1;
    
    @FXML
    private TextField txtV2;

    @FXML
    private TextField txtV1;

    @FXML
    private ComboBox<String> cboV2;

    @FXML
    private ComboBox<String> cboV1;
    
    @FXML
    private TextField txtL2;

    @FXML
    private TextField txtL1;

    @FXML
    private ComboBox<String> cboL2;

    @FXML
    private ComboBox<String> cboL1;

    HashMap<String, Integer> map = new HashMap<>();
    
    @FXML
    void changer(ActionEvent e)
    {
    	Button b=(Button)e.getSource();
    	String a=b.getText();
    	monPane.getSelectionModel().select(map.get(a));
    	
    }
    
    
    public void initialize(URL arg0, ResourceBundle arg1)
    {
    	map.put("Mass", 1);
    	map.put("Longeur", 3);
    	map.put("Volume", 2);
    	cboM1.setItems(ListMass);
		cboM2.setItems(ListMass);
		cboM1.getSelectionModel().selectFirst();
		cboM2.getSelectionModel().selectFirst();
		cboV1.setItems(ListVolume);
		cboV2.setItems(ListVolume);
		cboV1.getSelectionModel().selectFirst();
		cboV2.getSelectionModel().selectFirst();
		cboL1.setItems(ListLongeur);
		cboL2.setItems(ListLongeur);
		cboL1.getSelectionModel().selectFirst();
		cboL2.getSelectionModel().selectFirst();
		
    }
    
    
    
    private ObservableList<String> ListMass=FXCollections.observableArrayList("kg","g","mg","t","lbs");
    private double []Mass= {1.0, 1000.0, 1000000.0, 0.001, 2.2046};
   
    private ObservableList<String> ListVolume=FXCollections.observableArrayList("L","ml","ounce","gallon","tbs");
    private double []Volume= {1.0, 1000.0, 33.814, 0.2642, 67.628};
    
    private ObservableList<String> ListLongeur=FXCollections.observableArrayList("m","km","cm","mm","inch");
    private double []Longeur= {1.0, 0.001, 100.0, 1000.0, 39.37};
    
    //
    //
    //

    private double setTaux(ComboBox a, double tbl [])
	{
		return tbl[a.getSelectionModel().getSelectedIndex()];
	}
	

	@FXML
	private void convert1M()
	{
		convertir(cboM1,cboM2,txtM1,txtM2,Mass);
	}
	
	@FXML
	private void convert2M()
	{
		convertir(cboM2,cboM1,txtM2,txtM1,Mass);
	}
	
	
	@FXML
	private void convert1V()
	{
		convertir(cboV1,cboV2,txtV1,txtV2,Volume);
	}
	
	@FXML
	private void convert2V()
	{
		convertir(cboV2,cboV1,txtV2,txtV1,Volume);
	}
	
	
	@FXML
	private void convert1L()
	{
		convertir(cboL1,cboL2,txtL1,txtL2,Longeur);
	}
	
	@FXML
	private void convert2L()
	{
		convertir(cboL2,cboL1,txtL2,txtL1,Longeur);
	}

	
	private void convertir(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
	{
		double from=setTaux(a,tbl);
		double to=setTaux(b,tbl);
		double depart=0.0;		
		depart=c.getText().equals("")?0.0:Double.parseDouble(c.getText());
		double dest=(to/from)*depart;
		d.setText(String.valueOf(dest));
	}
	
	@FXML
	public void verifNum(KeyEvent e)
	{
	TextField txt=(TextField)e.getSource();

		txt.textProperty().addListener((observable,oldValue,newValue)->
		{
			if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
			{
				txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
			}

		});
	}
   

 	
}
