package games;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import screens.DungeonFrame;

public class SpellBook {
	TableView<Spell> table = new TableView<Spell>();
	final Label item = new Label("Spell");
    final VBox vbox = new VBox();
	Button backButton;
	static ObservableList<Spell> data=FXCollections.observableArrayList();
    static ArrayList<Spell> playerSpells = new ArrayList<>();
    TableColumn<Spell, String> itemNameCol = new TableColumn<Spell, String>("Name");
    TableColumn<Spell, Integer> spellDMGCol = new TableColumn<Spell, Integer>("Damage");
    TableColumn<Spell, Integer> spellManaCol = new TableColumn<Spell, Integer>("Mana Cost");
    TableColumn<Spell, String> spellDescCol = new TableColumn<Spell, String>("Effects");
    
    @SuppressWarnings("unchecked")
	public void displaySpellBook() {
    	Frame.spellBookScene = new Scene(new Group(),600,800);
    	table.setPlaceholder(new Label("You Dont know any Spells!"));
        table.setItems(data);
    	
        
        itemNameCol.setCellValueFactory(new PropertyValueFactory<Spell, String>("spellName"));
        spellDMGCol.setCellValueFactory(new PropertyValueFactory<Spell, Integer>("spellDmg"));
        spellManaCol.setCellValueFactory(new PropertyValueFactory<Spell, Integer>("manaCost"));
        spellDescCol.setCellValueFactory(new PropertyValueFactory<Spell, String>("effect"));
        final ContextMenu cm = new ContextMenu();
		MenuItem cmItem1 = new MenuItem("Select Default Spell");
		cmItem1.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	Spell item =table.getSelectionModel().getSelectedItem();
		    	if(item != null) {
		    		String selectedSpell = "You selected "+ item.spellName;
		        	DungeonFrame.textArea.appendText(selectedSpell+" as default Spell \n");
		        	item.setSpell(item);
		    	}
		    }
		});
		
		cm.getItems().add(cmItem1);
        table.setOnMousePressed(event ->{
        	Spell item =table.getSelectionModel().getSelectedItem();
        	if(item!=null) {
        		 cm.show(table, event.getScreenX(), event.getScreenY());
        	}
        });
        
        
        table.getColumns().addAll(itemNameCol,spellDMGCol,spellManaCol,spellDescCol);
        backButton = new Button("Continue");
		backButton.setOnAction(e ->{
		DungeonFrame hsb = new DungeonFrame();
		hsb.setDungeonFrame();
		});
        
        
		vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        item.setFont(new Font("Arial", 20));
        table.setEditable(false);
        vbox.getChildren().addAll(item,table,backButton);
       // double height =(Double)Frame.spellBookScene.heightProperty();
      //  Frame.spellBookScene.heightProperty().
        table.prefHeightProperty().bind(Frame.spellBookScene.heightProperty().subtract(100));
        table.prefWidthProperty().bind(Frame.spellBookScene.widthProperty()); 
        
        ((Group) Frame.spellBookScene.getRoot()).getChildren().addAll(vbox);
        
        Frame.getWindow().setScene(Frame.spellBookScene);
        
    	
    }
	public TableView<Spell> getTable() {
		return table;
	}
	public void setTable(TableView<Spell> tableIn) {
		table = tableIn;
	}
	public ObservableList<Spell> getData() {
		return data;
	}
	public void setData(ObservableList<Spell> dataIn) {
		data = dataIn;
	}
	public void addItem(Spell spell) {
		playerSpells.add(spell);
		data.add(spell);
	}
	
	public void emptySpellBook() {
		 data.removeAll(data);
	}
	
	
}
