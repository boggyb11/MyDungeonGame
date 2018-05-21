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

public class Backpack {
	
		TableView<LootTable> table = new TableView<LootTable>();
		final Label item = new Label("Backpack");
        final VBox vbox = new VBox();
        Button backButton = new Button("Continue");
        static ObservableList<LootTable> data=FXCollections.observableArrayList();
        static ArrayList<LootTable> playerLoot = new ArrayList<>();
        TableColumn<LootTable, String> itemNameCol = new TableColumn<LootTable, String>("Name");
        TableColumn<LootTable, String> itemHPCol = new TableColumn<LootTable, String>("HP");
        TableColumn<LootTable, String> itemMPCol = new TableColumn<LootTable, String>("MP");
        TableColumn<LootTable, String> itemARMCol = new TableColumn<LootTable, String>("Armour");
        TableColumn<LootTable, String> itemDMGCol = new TableColumn<LootTable, String>("Damage");
        final ContextMenu cm = new ContextMenu();
		MenuItem cmItem1 = new MenuItem("Use Item");
        
	@SuppressWarnings("unchecked")
	public void displayBackpack() {
			Frame.scene5 = new Scene(new Group(),600,800);
			table.setPlaceholder(new Label("You have no items in your Backpack..!"));
	        table.setItems(data);
	        itemNameCol.setCellValueFactory(new PropertyValueFactory<LootTable, String>("Name"));
	        itemHPCol.setCellValueFactory(new PropertyValueFactory<LootTable, String>("HP"));
	        itemMPCol.setCellValueFactory(new PropertyValueFactory<LootTable, String>("MP"));
	        itemARMCol.setCellValueFactory(new PropertyValueFactory<LootTable, String>("Armour"));
	        itemDMGCol.setCellValueFactory(new PropertyValueFactory<LootTable, String>("Damage"));
			cm.getItems().add(cmItem1);
	        setOnAction();
	        
		    table.getColumns().addAll(itemNameCol,itemHPCol,itemMPCol,itemARMCol,itemDMGCol);//adds a new column
	        
		    vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        item.setFont(new Font("Arial", 20));
	        table.setEditable(false);
	        vbox.getChildren().addAll(item,table,backButton);
	        
	        table.prefHeightProperty().bind(Frame.scene5.heightProperty().subtract(100));
	        table.prefWidthProperty().bind(Frame.scene5.widthProperty()); 
	        
	        
	        ((Group) Frame.scene5.getRoot()).getChildren().addAll(vbox);
	        Frame.getWindow().setScene(Frame.scene5);
	}
	
	
	
	
	public void setOnAction() {
		backButton.setOnAction(e ->{
			DungeonFrame hsb = new DungeonFrame();
			hsb.setDungeonFrame();
			});
		
		cmItem1.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	LootTable item =table.getSelectionModel().getSelectedItem();
		    	if(item != null) {
		    		String usedItem = "You used "+ item +"!!\n";
		    		DungeonFrame.textArea.appendText(usedItem);
		        	item.use(item);
		        	data.remove(item);
		    	}
		    }
		});
		
//		cm.getItems().add(cmItem1);
		 table.setOnMousePressed(event ->{
	        	//Create a menu here at clicked location
	        	LootTable item =table.getSelectionModel().getSelectedItem();
	        	if(item!=null) {
	        		 cm.show(table, event.getScreenX(), event.getScreenY());
	        	}
	        });
		
	}
	
	
	
	
	
	
	
	
	public TableView<LootTable> getTable() {
		return table;
	}
	public void setTable(TableView<LootTable> tableIn) {
		table = tableIn;
	}
	public ObservableList<LootTable> getData() {
		return data;
	}
	public void setData(ObservableList<LootTable> dataIn) {
		data = dataIn;
	}
	public void addItem(LootTable loot) {
		playerLoot.add(loot);
		data.add(loot);
		System.out.println(data);
	}
	
	public void emptyBackpack() {
		 data.removeAll(data);
	}
}
