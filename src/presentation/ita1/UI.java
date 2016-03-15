package presentation.ita1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.html.ImageView;

import java.awt.Font;
import java.awt.Rectangle;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

import org.json.JSONException;

import businesslogic.GrailsBL.GrailsBL;
import businesslogic.StocksBL.StocksBL;
import bussinesslogicservice.GrailsBLService.GrailsBLService;
import bussinesslogicservice.StocksBLService.StocksBLService;
import vo.*;
import data.NameGetter;
import data.ReadStocks_resolved;
import dataservice.StockNameGetService;


public class UI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Us;
	private JPanel panel_input_stocks;
	private JPanel panel_input_grails;
	private JPanel panel_present_stocks;
	private JPanel panel_present_grails;
	private JPanel panel_input_StocksSearch;
	private JPanel panel_present_stocks_Details;
	private JPanel panel_function;
	private JTable table;
	private JTextField textField;
    private DefaultTableModel stocksPresentBaseModel;
    private DefaultTableModel stocksPresentDetailsModel;
    private DefaultTableModel grailsPresentBaseModel;
    private DefaultTableCellRenderer renderer;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTable table_1;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTable table_2;
    private JLabel lblNewLabel_3;
    private String numOfStock;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setResizable(false);
		this.setTitle("ASAA");
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon icon=new ImageIcon("background.jpg");
	    //Image im=new Image(icon);
	    //将图片放入label中
	    JLabel label=new JLabel(icon);
	    
	    //设置label的大小
	    label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
	    
	    getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//重要！！！！！
	    
	    //contentPane.add(label);
	    contentPane.setOpaque(false);
	    
	    //******************************************************************************************************以上为设置背景
	    stocksPresentBaseModel = new DefaultTableModel(0, 10){
	    	  public boolean isCellEditable(int row,int column)
	    	  {
	    	   return false;
	    	  }
	    	  public String getColumnName(int columnIndex){
	    		  if(columnIndex == 0) return "股票代码"; 
	    		  if(columnIndex == 2) return "日期";
	    		  if(columnIndex == 5) return "最高价";
	    		  if(columnIndex == 6) return "最低价";
	    		  if(columnIndex == 4) return "收盘价";
	    		  if(columnIndex == 7) return "成交量(百股)";
	    		  if(columnIndex == 8) return "换手率";
	    		  if(columnIndex == 9) return "市净率";
	    		  if(columnIndex == 3) return "开盘价";
	    		  if(columnIndex == 1) return "股票名称"; 
				return null;
	    		  
	    		  
	    	  }
	    	 };
	    	//******************************************************************************************************以上为股票基本展示表格组件
	    	 stocksPresentDetailsModel = new DefaultTableModel(0, 8){
		    	  public boolean isCellEditable(int row,int column)
		    	  {
		    	   return false;
		    	  }
		    	  public String getColumnName(int columnIndex){
		    		  if(columnIndex == 0) return "日期"; 
		    		  if(columnIndex == 3) return "最高价";
		    		  if(columnIndex == 4) return "最低价";
		    		  if(columnIndex == 2) return "收盘价";
		    		  if(columnIndex == 5) return "成交量(百股)";
		    		  if(columnIndex == 6) return "换手率";
		    		  if(columnIndex == 7) return "市净率";
		    		  if(columnIndex == 1) return "开盘价";
					return null;
		    		  
		    		  
		    	  }
		    	 };
	    //******************************************************************************************************以上为股票详细展示表格组件
		    	 grailsPresentBaseModel=new DefaultTableModel(0, 5){
			    	  public boolean isCellEditable(int row,int column)
			    	  {
			    	   return false;
			    	  }
			    	  public String getColumnName(int columnIndex){
			    		  if(columnIndex == 0) return "日期"; 
			    		  if(columnIndex == 1) return "开盘价";
			    		  if(columnIndex == 2) return "收盘价";
			    		  if(columnIndex == 3) return "最高价";
			    		  if(columnIndex == 4) return "最低价";
			    		 
						return null;
			    		  
			    		  
			    	  }
			    	 };
		 //******************************************************************************************************以上为大盘基本展示表格组件 
			    	 renderer=new DefaultTableCellRenderer();
			          renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			          renderer.setOpaque(false);
			    	 
			    	 
	    panel_function = new JPanel();
	    panel_function.setForeground(Color.WHITE);
	    panel_function.setBounds(0, 170, 279, 520);
	    contentPane.add(panel_function);
	    panel_function.setLayout(null);
	    panel_function.setOpaque(false);//透明
	    
	    
	    JButton btnNewButton = new JButton(" ");
	    buttonSet(btnNewButton,"按钮股票查看.png");
//	    btnNewButton.setBackground(new Color(255,255,255));  
//	    btnNewButton.setBorder(null); 
//	    btnNewButton.setOpaque(false);
//	    btnNewButton.setForeground(Color.WHITE);
	    btnNewButton.setFont(new Font("楷体", Font.BOLD, 24));
    
	    
	  
	   
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_present_stocks.setVisible(true);
	    		panel_input_stocks.setVisible(true);	    		
	    		panel_input_grails.setVisible(false);
	    		panel_present_grails.setVisible(false);
	    		panel_input_StocksSearch.setVisible(false);
	    		panel_present_stocks_Details.setVisible(false);
	    		panel_Us.setVisible(false);
	    	}
	    });
	    btnNewButton.setBounds(61, 24, 160, 46);
	   
	    //btnNewButton.setBounds(12, 24, 1000, 500);
	    panel_function.add(btnNewButton);
	    
	    JButton button = new JButton(" ");
	    button.setForeground(Color.WHITE);
	   //buttonSet(button);
	    
	    
	    button.setFont(new Font("楷体", Font.BOLD, 24));
	    button.setBounds(61, 83, 160, 46);
	    buttonSet(button,"按钮大盘查看.png");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_present_stocks.setVisible(false);
	    		panel_input_stocks.setVisible(false);	    		
	    		panel_input_grails.setVisible(true);
	    		panel_present_grails.setVisible(true);
	    		panel_input_StocksSearch.setVisible(false);
	    		panel_present_stocks_Details.setVisible(false);
	    		panel_Us.setVisible(false);
	    	}
	    });
	    
	    
	    
	    
	    
	    
	    
	    panel_function.add(button);
	    
	    
	    
	    
	    
	    //设置表格基本信息
	    
	     panel_input_stocks = new JPanel();
	    
	    panel_input_stocks.setVisible(false);
	    panel_input_stocks.setOpaque(false);
	    panel_input_stocks.setBounds(279, 0, 995, 172);
	    contentPane.add(panel_input_stocks);
	    panel_input_stocks.setLayout(null);
	   
	    
	    JLabel lblNewLabel = new JLabel("股票代码");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
	    lblNewLabel.setBounds(22, 31, 110, 59);
	    panel_input_stocks.add(lblNewLabel);
	    
	    textField = new JTextField();
	    textField.setBounds(144, 42, 88, 35);
	    panel_input_stocks.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton_1 = new JButton(" ");
	    buttonSet(btnNewButton_1,"按钮添加.png");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 String stocks=textField.getText();
	    		
	    		 
	    			    Pattern pattern = Pattern.compile("[0-9]*"); 
	    			    if( !pattern.matcher(stocks).matches()){
	    			    	JOptionPane.showMessageDialog(null, "请输入数字！","", JOptionPane.ERROR_MESSAGE);
	    			    }
	    			    else if(stocks.equals("")){
	    			    	JOptionPane.showMessageDialog(null, "请输入股票代码！","", JOptionPane.ERROR_MESSAGE);
	    			    }
	    			    else{
	    			    	ReadStocks_resolved reader=new ReadStocks_resolved();
	    			    	if(reader.checkStock(stocks)){
	    			    		if(addStocksBase(textField.getText()))
	    			    			reader.addStock(stocks);
	    			    		
	    			    			
	    			    	}
	    			    		
	    			    	else
	    			    		JOptionPane.showMessageDialog(null, "该股票已存在！","", JOptionPane.ERROR_MESSAGE);
	    			    	
	    		    	   	
	    			    }
 			    textField.setText("");

	    	}
	    });
	    btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
	    btnNewButton_1.setBounds(63, 94, 123, 59);
	    panel_input_stocks.add(btnNewButton_1);
	    
	    JButton button_1 = new JButton(" ");
	    buttonSet(button_1,"查看具体信息.png");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int SelectedRow=table.getSelectedRow();
	    		if(SelectedRow==-1)
	    			JOptionPane.showMessageDialog(null, "请选择一个股票！","", JOptionPane.ERROR_MESSAGE);
	    		else{
	    		DefaultTableModel model=(DefaultTableModel)table.getModel();
	    		numOfStock=(String)model.getValueAt(SelectedRow, 0);
	    		//*******************************************************************************************************
	    		//要加入下层的传入股票的具体信息,不用搜索，用默认最近一个月的方法
	    		
	    		
	    		StocksBLService bl=new StocksBL();
	    		ArrayList<StocksVO> detailList=null;
	    		
	    		try {
	    			detailList=bl.getDetailsOfStock(numOfStock);
	    			setStocksDetails(detailList);
	    			
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    		
	    		panel_input_stocks.setVisible(false);
	    		panel_present_stocks.setVisible(false);
	    		
	    		StockNameGetService NameGet=new NameGetter();
				String name=NameGet.getName(numOfStock);
	    		
	    		
	    		lblNewLabel_3.setText(name+"("+numOfStock+")"+"的历史交易记录");
	    		
	    		 panel_input_StocksSearch.setVisible(true);
	    		panel_present_stocks_Details.setVisible(true);
	    		
	    	}
	    	}
	    });
	    button_1.setFont(new Font("楷体", Font.PLAIN, 18));
	    button_1.setBounds(238, 94, 161, 58);
	    panel_input_stocks.add(button_1);
	    
	    JButton button_2 = new JButton(" ");
	    buttonSet(button_2,"按钮删除所选股票.png");
	    button_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int SelectedRow=table.getSelectedRow();
	    		if(SelectedRow==-1)
	    			JOptionPane.showMessageDialog(null, "请选择一个股票！","", JOptionPane.ERROR_MESSAGE);
	    		else{
	    			DefaultTableModel model=(DefaultTableModel)table.getModel();
		    		String numOfStock=(String)model.getValueAt(SelectedRow, 0);
		    		ReadStocks_resolved reader=new ReadStocks_resolved();
		    		reader.removeStock(numOfStock); 		
		    		stocksPresentBaseModel.removeRow(SelectedRow);
	    		}
	    		
	    
	    		
	    	}
	    });
	    button_2.setFont(new Font("楷体", Font.PLAIN, 18));
	    button_2.setBounds(460, 94, 161, 58);
	    panel_input_stocks.add(button_2);
	    
	   

	    
	    panel_input_StocksSearch = new JPanel();	    
	    
	    panel_input_StocksSearch.setVisible(false);//**********
	    
	    panel_input_StocksSearch.setOpaque(false);//透明
	    panel_input_StocksSearch.setBounds(279, 0, 995, 172);
	    contentPane.add(panel_input_StocksSearch);
	    panel_input_StocksSearch.setLayout(null);
	    
	    JLabel lblNewLabel_6 = new JLabel("单位：元");
	    lblNewLabel_6.setForeground(Color.WHITE);
	    lblNewLabel_6.setBounds(817, 63, 72, 37);
	    panel_input_StocksSearch.add(lblNewLabel_6);
	    lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    
	    JLabel lblNewLabel_1 = new JLabel("起始日期");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    lblNewLabel_1.setBounds(41, 34, 93, 36);
	    panel_input_StocksSearch.add(lblNewLabel_1);
	    
	    JLabel label_1 = new JLabel("结束日期");
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_1.setBounds(41, 81, 93, 36);
	    panel_input_StocksSearch.add(label_1);
	    
	    JLabel label_2 = new JLabel("(日期格式：如 2016-01-26)");
	    label_2.setForeground(Color.WHITE);
	    label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_2.setBounds(41, 125, 268, 36);
	    panel_input_StocksSearch.add(label_2);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(137, 43, 127, 27);
	    panel_input_StocksSearch.add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(137, 90, 127, 27);
	    panel_input_StocksSearch.add(textField_2);
	    
	    JLabel label_3 = new JLabel("开盘价范围");
	    label_3.setForeground(Color.WHITE);
	    label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_3.setBounds(286, 34, 93, 36);
	    panel_input_StocksSearch.add(label_3);
	    
	    JLabel label_4 = new JLabel("收盘价范围");
	    label_4.setForeground(Color.WHITE);
	    label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_4.setBounds(286, 81, 93, 36);
	    panel_input_StocksSearch.add(label_4);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(384, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_3);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(384, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_4);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(470, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_5);
	    
	    textField_6 = new JTextField();
	    textField_6.setColumns(10);
	    textField_6.setBounds(470, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_6);
	    
	    JLabel lblNewLabel_2 = new JLabel("~");
	    lblNewLabel_2.setForeground(Color.WHITE);
	    lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
	    lblNewLabel_2.setBounds(455, 54, 63, 16);
	    panel_input_StocksSearch.add(lblNewLabel_2);
	    
	    JLabel label_5 = new JLabel("~");
	    label_5.setForeground(Color.WHITE);
	    label_5.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_5.setBounds(455, 101, 63, 16);
	    panel_input_StocksSearch.add(label_5);
	    
	    JLabel label_6 = new JLabel("最高价范围");
	    label_6.setForeground(Color.WHITE);
	    label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_6.setBounds(540, 34, 93, 36);
	    panel_input_StocksSearch.add(label_6);
	    
	    JLabel label_7 = new JLabel("最低价范围");
	    label_7.setForeground(Color.WHITE);
	    label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_7.setBounds(540, 81, 93, 36);
	    panel_input_StocksSearch.add(label_7);
	    
	    textField_7 = new JTextField();
	    textField_7.setColumns(10);
	    textField_7.setBounds(636, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_7);
	    
	    JLabel label_8 = new JLabel("~");
	    label_8.setForeground(Color.WHITE);
	    label_8.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_8.setBounds(707, 54, 63, 16);
	    panel_input_StocksSearch.add(label_8);
	    
	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    textField_8.setBounds(722, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_8);
	    
	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    textField_9.setBounds(636, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_9);
	    
	    JLabel label_9 = new JLabel("~");
	    label_9.setForeground(Color.WHITE);
	    label_9.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_9.setBounds(707, 101, 63, 16);
	    panel_input_StocksSearch.add(label_9);
	    
	    textField_10 = new JTextField();
	    textField_10.setColumns(10);
	    textField_10.setBounds(722, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_10);
	    
	    JLabel label_10 = new JLabel("(日期必须输入，其余参数可不输入)");
	    label_10.setForeground(Color.WHITE);
	    label_10.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_10.setBounds(313, 125, 297, 36);
	    panel_input_StocksSearch.add(label_10);
	    
	    JButton btnNewButton_2 = new JButton(" ");
	    btnNewButton_2.setBounds(849, 94, 123, 58);
	    panel_input_StocksSearch.add(btnNewButton_2);
	    buttonSet(btnNewButton_2,"按钮搜索.png");
	    btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 18));
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		String kaipan1=textField_3.getText();
	    		String kaipan2=textField_5.getText();
	    		String shoupan1=textField_4.getText();
	    		String shoupan2=textField_6.getText();
	    		String max1=textField_7.getText();
	    		String max2=textField_8.getText();
	    		String min1=textField_9.getText();
	    		String min2=textField_10.getText();
	    		
	    		boolean isok=true;
	    		
	    		if(StocksSearchInfoChecker.checkisDate(textField_1.getText())){
	    			if(StocksSearchInfoChecker.checkisDate(textField_2.getText())){
	    			if(StocksSearchInfoChecker.checkDateOrder(textField_1.getText(), textField_2.getText())){
	    					
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "起始日期要在结束日期之前！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
	    				
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
		    				
			
	    		}	    			
	    		else{
	    			JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    			isok=false;
	    		}
	    			
	    		
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(kaipan1, kaipan2)){
	    				kaipan1="0";
	    				kaipan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(kaipan1, kaipan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "开盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(shoupan1, shoupan2)){
	    				shoupan1="0";
	    				shoupan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(shoupan1, shoupan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "收盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(max1, max2)){
	    				max1="0";
	    				max2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(max1, max2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最高价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(min1, min2)){
	    				min1="0";
	    				min2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(min1, min2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最低价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		
	    		if(isok){
	    			//********************************************************************************
	    			//往下传递搜索信息
	    			
	    			StocksBLService bl=new StocksBL();
	    			
	    			StocksSearchInfoVO info=new StocksSearchInfoVO(numOfStock,textField_1.getText(),textField_2.getText(),Double.parseDouble(kaipan1),Double.parseDouble(kaipan2),Double.parseDouble(shoupan1),Double.parseDouble(shoupan2),Double.parseDouble(max1),Double.parseDouble(max2),Double.parseDouble(min1),Double.parseDouble(min2));
	    			
	    		
	    			
	    			ArrayList<StocksVO> list=null;
	    			try {
	    				
	    				list=bl.stocksSearch(info);
	    				System.out.println(list.size());
	    				setStocksDetails(list);
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    			
	    			
	    			textField_1.setText("");
	    			textField_2.setText("");
	    			textField_3.setText("");
	    			textField_4.setText("");
	    			textField_5.setText("");
	    			textField_6.setText("");
	    			textField_7.setText("");
	    			textField_8.setText("");
	    			textField_9.setText("");
	    			textField_10.setText("");
	    			
	    			
	    		}
	    		
	    		
	    		
	    	}
	    });
	    
	     panel_input_grails = new JPanel();
	   
	    panel_input_grails.setVisible(false);//***********************
	    
	    panel_input_grails.setOpaque(false);
	    panel_input_grails.setBounds(279, 0, 995, 172);
	    panel_input_grails.setLayout(null);
	    contentPane.add(panel_input_grails);
	    
	    JLabel lblNewLabel_4 = new JLabel("起始日期");
	    lblNewLabel_4.setForeground(Color.WHITE);
	    lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    lblNewLabel_4.setBounds(40, 29, 81, 32);
	    panel_input_grails.add(lblNewLabel_4);
	    
	    JLabel label_11 = new JLabel("结束日期");
	    label_11.setForeground(Color.WHITE);
	    label_11.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_11.setBounds(40, 75, 81, 32);
	    panel_input_grails.add(label_11);
	    
	    textField_11 = new JTextField();
	    textField_11.setBounds(133, 31, 104, 32);
	    panel_input_grails.add(textField_11);
	    textField_11.setColumns(10);
	    
	    textField_12 = new JTextField();
	    textField_12.setColumns(10);
	    textField_12.setBounds(133, 77, 104, 32);
	    panel_input_grails.add(textField_12);
	    
	    JLabel label_12 = new JLabel("开盘价");
	    label_12.setForeground(Color.WHITE);
	    label_12.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_12.setBounds(261, 29, 81, 32);
	    panel_input_grails.add(label_12);
	    
	    JLabel label_13 = new JLabel("收盘价");
	    label_13.setForeground(Color.WHITE);
	    label_13.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_13.setBounds(261, 75, 81, 32);
	    panel_input_grails.add(label_13);
	    
	    textField_13 = new JTextField();
	    textField_13.setColumns(10);
	    textField_13.setBounds(329, 31, 44, 32);
	    panel_input_grails.add(textField_13);
	    
	    JLabel label_14 = new JLabel("~");
	    label_14.setForeground(Color.WHITE);
	    label_14.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_14.setBounds(374, 40, 36, 21);
	    panel_input_grails.add(label_14);
	    
	    textField_14 = new JTextField();
	    textField_14.setColumns(10);
	    textField_14.setBounds(385, 31, 44, 32);
	    panel_input_grails.add(textField_14);
	    
	    textField_15 = new JTextField();
	    textField_15.setColumns(10);
	    textField_15.setBounds(385, 75, 44, 32);
	    panel_input_grails.add(textField_15);
	    
	    JLabel label_15 = new JLabel("~");
	    label_15.setForeground(Color.WHITE);
	    label_15.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_15.setBounds(374, 84, 36, 21);
	    panel_input_grails.add(label_15);
	    
	    textField_16 = new JTextField();
	    textField_16.setColumns(10);
	    textField_16.setBounds(329, 75, 44, 32);
	    panel_input_grails.add(textField_16);
	    
	    textField_17 = new JTextField();
	    textField_17.setColumns(10);
	    textField_17.setBounds(581, 31, 44, 32);
	    panel_input_grails.add(textField_17);
	    
	    JLabel label_16 = new JLabel("~");
	    label_16.setForeground(Color.WHITE);
	    label_16.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_16.setBounds(570, 40, 36, 21);
	    panel_input_grails.add(label_16);
	    
	    textField_18 = new JTextField();
	    textField_18.setColumns(10);
	    textField_18.setBounds(525, 31, 44, 32);
	    panel_input_grails.add(textField_18);
	    
	    JLabel label_17 = new JLabel("最高价");
	    label_17.setForeground(Color.WHITE);
	    label_17.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_17.setBounds(457, 29, 81, 32);
	    panel_input_grails.add(label_17);
	    
	    textField_19 = new JTextField();
	    textField_19.setColumns(10);
	    textField_19.setBounds(581, 74, 44, 32);
	    panel_input_grails.add(textField_19);
	    
	    JLabel label_18 = new JLabel("~");
	    label_18.setForeground(Color.WHITE);
	    label_18.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_18.setBounds(570, 83, 36, 21);
	    panel_input_grails.add(label_18);
	    
	    textField_20 = new JTextField();
	    textField_20.setColumns(10);
	    textField_20.setBounds(525, 74, 44, 32);
	    panel_input_grails.add(textField_20);
	    
	    JLabel label_19 = new JLabel("最低价");
	    label_19.setForeground(Color.WHITE);
	    label_19.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_19.setBounds(457, 72, 81, 32);
	    panel_input_grails.add(label_19);
	    
	    JLabel label_20 = new JLabel("（日期格式如2016-01-01）");
	    label_20.setForeground(Color.WHITE);
	    label_20.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_20.setBounds(78, 118, 242, 32);
	    panel_input_grails.add(label_20);
	    
	    JLabel label_21 = new JLabel("单位（元）");
	    label_21.setForeground(Color.WHITE);
	    label_21.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_21.setBounds(405, 118, 114, 32);
	    panel_input_grails.add(label_21);
	    
	    JButton btnNewButton_3 = new JButton(" ");
	    btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 16));
	    buttonSet(btnNewButton_3,"按钮搜索.png");
	    btnNewButton_3.setBounds(673, 57, 123, 58);
	    btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String kaipan1=textField_13.getText();
	    		String kaipan2=textField_14.getText();
	    		String shoupan1=textField_16.getText();
	    		String shoupan2=textField_15.getText();
	    		String max1=textField_18.getText();
	    		String max2=textField_17.getText();
	    		String min1=textField_20.getText();
	    		String min2=textField_19.getText();
	    		
	    		boolean isok=true;
	    		
	    		if(StocksSearchInfoChecker.checkisDate(textField_11.getText())){
	    			if(StocksSearchInfoChecker.checkisDate(textField_12.getText())){
	    			if(StocksSearchInfoChecker.checkDateOrder(textField_11.getText(), textField_12.getText())){
	    					
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "起始日期要在结束日期之前！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
	    				
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
		    				
			
	    		}	    			
	    		else{
	    			JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    			isok=false;
	    		}
	    			
	    		
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(kaipan1, kaipan2)){
	    				kaipan1="0";
	    				kaipan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(kaipan1, kaipan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "开盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(shoupan1, shoupan2)){
	    				shoupan1="0";
	    				shoupan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(shoupan1, shoupan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "收盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(max1, max2)){
	    				max1="0";
	    				max2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(max1, max2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最高价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(min1, min2)){
	    				min1="0";
	    				min2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(min1, min2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最低价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		
	    		if(isok){
	    			//********************************************************************************
	    			//往下传递搜索信息
	    			GrailsSearchVO info=new GrailsSearchVO(textField_11.getText(),textField_12.getText(),Double.parseDouble(kaipan1),Double.parseDouble(kaipan2),Double.parseDouble(shoupan1),Double.parseDouble(shoupan2),Double.parseDouble(max1),Double.parseDouble(max2),Double.parseDouble(min1),Double.parseDouble(min2));
	    			
	    			
	    			setGrailsBase(info);
			
	    			textField_11.setText("");
	    			textField_12.setText("");
	    			textField_13.setText("");
	    			textField_14.setText("");
	    			textField_15.setText("");
	    			textField_16.setText("");
	    			textField_17.setText("");
	    			textField_18.setText("");
	    			textField_19.setText("");
	    			textField_20.setText("");
	    			
	    			
	    		}
	    		
	    		
	    		
	    	}
	    });
	    
	    
	    
	    panel_input_grails.add(btnNewButton_3);
	    
	    JLabel label_22 = new JLabel("（日期必填，其余可不填）");
	    label_22.setForeground(Color.WHITE);
	    label_22.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_22.setBounds(621, 118, 242, 32);
	    panel_input_grails.add(label_22);
	    
	    panel_present_grails = new JPanel();
	    panel_present_grails.setOpaque(false);
	    panel_present_grails.setVisible(false);//****************
	    
	    
	    
	     panel_present_stocks = new JPanel();
	     panel_present_stocks.setOpaque(false);
	     panel_present_stocks.setVisible(false);//***********************
	    
	   
	    panel_present_stocks.setBounds(279, 170, 995, 520);
	    contentPane.add(panel_present_stocks);
	    panel_present_stocks.setLayout(null);
	    
	     
	     JScrollPane scrollPane = new JScrollPane();
	     scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	     scrollPane.getViewport().setOpaque(false);
	     scrollPane.setOpaque(false);
	     scrollPane.setBounds(0,0,995,520);
	     panel_present_stocks.add(scrollPane);
	     
	     
	     
	     //*************************************************************************************
	     
	     
	     
	     	 
	     table = new JTable(stocksPresentBaseModel);
	     table.setForeground(Color.WHITE);
	     table.setBackground(Color.WHITE);
	     table.setFillsViewportHeight(true);
	    
	     
	     
	     table.setFont(new Font("微软雅黑", Font.BOLD, 18));
	     table.setDefaultRenderer(Object.class, renderer);
	     table.setOpaque(false);
	     
	     table.setRowSelectionAllowed(true);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     scrollPane.setViewportView(table);//重要！
	     
	     scrollPane.setColumnHeaderView(table.getTableHeader());//设置头部（HeaderView部分）  
	        scrollPane.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  
	        
        JTableHeader header = table.getTableHeader();//获取头部   
//        header.setPreferredSize(new Dimension(30, 26));   
	        header.setOpaque(false);//设置头部为透明  
	        header.getTable().setOpaque(false);//设置头部里面的表格透明  
	        
	        header.setDefaultRenderer(renderer);  
	        TableCellRenderer headerRenderer = header.getDefaultRenderer();   
	        if (headerRenderer instanceof JLabel)   
	        {  
	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
	            ((JLabel) headerRenderer).setOpaque(false);   
	        }  
	        
	     table.setBorder(new LineBorder(new Color(0, 0, 0)));
	     table.setRowHeight(40);
	     TableColumnModel   cm   =   table.getColumnModel();     //表格的列模型
	    panel_present_grails.setBounds(279, 170, 995, 520);
	    panel_present_grails.setLayout(null);
	    contentPane.add(panel_present_grails);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setOpaque(false);
	    scrollPane_2.getViewport().setOpaque(false);//将JScrollPane设置为透明  
	  
        
	    scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane_2.setBounds(0, 0, 995, 520);
	    panel_present_grails.add(scrollPane_2);
	    
	    table_2 = new JTable(grailsPresentBaseModel);
	    table_2.setForeground(Color.WHITE);
	    table_2.setBackground(Color.WHITE);
	    table_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    table_2.setDefaultRenderer(Object.class, renderer);
	    scrollPane_2.setColumnHeaderView(table_2);
	    table_2.setRowSelectionAllowed(true);
	    table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//重要！可以用横滚动条
	    table_2.setFillsViewportHeight(true);//重要！
	    scrollPane_2.setViewportView(table_2);//重要！
	    table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    table_2.setRowHeight(40);
	    TableColumnModel   cm_3   =   table_2.getColumnModel();     //表格的列模型
	    for(int i=0;i<5;i++){
	    TableColumn column= cm_3.getColumn(i);//得到第i个列对象   
	    column.setPreferredWidth(200);//将此列的首选宽度设置为 preferredWidth。
	    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    
	    column.setMaxWidth(200);
	    column.setMinWidth(200);
	    }
	    //设置透明
	    scrollPane_2.setColumnHeaderView(table_2.getTableHeader());//设置头部（HeaderView部分）  
        scrollPane_2.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
        
	    table_2.setOpaque(false);
scrollPane_2.getViewport().setOpaque(false);
	     scrollPane_2.setOpaque(false);
scrollPane_2.setColumnHeaderView(table_2.getTableHeader());//设置头部（HeaderView部分）  
	        scrollPane_2.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  
	        
       JTableHeader header_2 = table_2.getTableHeader();//获取头部   
  
	        header_2.setOpaque(false);//设置头部为透明  
	        header_2.getTable().setOpaque(false);//设置头部里面的表格透明  
	        
	        header_2.setDefaultRenderer(renderer);  
	     
	       




	    
	    
	    
	    
	     panel_present_stocks_Details = new JPanel();
	    
	    panel_present_stocks_Details.setVisible(false);//***********************
	    panel_present_stocks_Details.setOpaque(false);
        panel_present_stocks_Details.setForeground(Color.WHITE);
	    panel_present_stocks_Details.setBackground(Color.WHITE);
	    panel_present_stocks_Details.setBounds(279, 170, 995, 520);
	    contentPane.add(panel_present_stocks_Details);
	    panel_present_stocks_Details.setLayout(null);
	    
	    lblNewLabel_3 = new JLabel("的历史交易记录");
	    lblNewLabel_3.setBounds(330, 11, 400, 41);
	    panel_present_stocks_Details.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 24));
	    lblNewLabel_3.setForeground(Color.WHITE);
	    
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane_1.setBounds(0, 54, 995, 466);
	    panel_present_stocks_Details.add(scrollPane_1);
	    
	    table_1 = new JTable(stocksPresentDetailsModel);
	    table_1.setOpaque(false);
	    scrollPane_1.getViewport().setOpaque(false);
	    scrollPane_1.setOpaque(false);
	    scrollPane_1.setColumnHeaderView(table_1.getTableHeader());//设置头部（HeaderView部分）  
	    scrollPane_1.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  	   	        
	           JTableHeader header_1 = table_1.getTableHeader();//获取头部   	      
	           header_1.setOpaque(false);//设置头部为透明  
	           header_1.getTable().setOpaque(false);//设置头部里面的表格透明  
	   	        
	           header_1.setDefaultRenderer(renderer);  
//	   	        TableCellRenderer headerRenderer_1 = header_1.getDefaultRenderer();   
//	   	        if (headerRenderer_1 instanceof JLabel)   
//	   	        {  
//	   	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
//	   	            ((JLabel) headerRenderer).setOpaque(false);   
//	   	        }
	    table_1.setBackground(Color.WHITE);
	    table_1.setForeground(Color.WHITE);
	    table_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    table_1.setDefaultRenderer(Object.class, renderer);
	    table_1.setFillsViewportHeight(true);
	    scrollPane_1.setColumnHeaderView(table_1);
	    scrollPane_1.setViewportView(table_1);//重要！让表格完全覆盖滚动层！
	    table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//重要！可以用横滚动条
	    table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	    table_1.setRowHeight(40);
	    
	    panel_Us = new JPanel();
	    panel_Us.setBounds(279, 0, 995, 690);
	    panel_Us.setOpaque(false);
	    contentPane.add(panel_Us);
	    panel_Us.setLayout(null);
	    
	    JLabel lblNewLabel_5 = new JLabel("Produced by:       龚臣      毛越\r\n");
	    lblNewLabel_5.setForeground(new Color(255, 255, 255));
	    lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 30));
	    lblNewLabel_5.setBounds(81, 242, 741, 104);
	    panel_Us.add(lblNewLabel_5);
	    
	    JLabel label_23 = new JLabel("李翔      栾志远\r\n");
	    label_23.setForeground(Color.WHITE);
	    label_23.setFont(new Font("楷体", Font.BOLD, 30));
	    label_23.setBounds(400, 371, 352, 104);
	    panel_Us.add(label_23);
	    
	    JLabel lblanyquantA = new JLabel("欢迎使用AnyQuant A股搜索分析系统\r\n");
	    lblanyquantA.setForeground(Color.WHITE);
	    lblanyquantA.setFont(new Font("楷体", Font.BOLD, 30));
	    lblanyquantA.setBounds(228, 49, 547, 104);
	    panel_Us.add(lblanyquantA);
	    TableColumnModel   cm_1   =   table_1.getColumnModel();     //表格的列模型
	    for(int i=0;i<8;i++){
	    	if(i==0||i==5){
	    		 TableColumn column= cm_1.getColumn(i);//得到第i个列对象   
	    		    column.setPreferredWidth(150);//将此列的首选宽度设置为 preferredWidth。
	    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    		    
	    		    column.setMaxWidth(200);
	    		    column.setMinWidth(150);
	    		
	    		
	    	}
	    	else{
	    		TableColumn column= cm_1.getColumn(i);//得到第i个列对象   
    		    column.setPreferredWidth(120);//将此列的首选宽度设置为 preferredWidth。
    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
    		    
    		    column.setMaxWidth(120);
    		    column.setMinWidth(120);
	    		
	    		
	    	}
	    }
	    for(int i=0;i<10;i++){
	    	if(i!=1&&i!=0&&i!=7&&i!=2){
	    TableColumn column= cm.getColumn(i);//得到第i个列对象   
	    column.setPreferredWidth(100);//将此列的首选宽度设置为 preferredWidth。
	    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    
	    column.setMaxWidth(100);
	    column.setMinWidth(100);
	    	}
	    	else{
	    		 TableColumn column= cm.getColumn(i);//得到第i个列对象   
	    		    column.setPreferredWidth(150);//将此列的首选宽度设置为 preferredWidth。
	    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    		    
	    		    column.setMaxWidth(200);
	    		    column.setMinWidth(150);
	    		
	    	}
	    }
	    //设置表格基本信息
	   
	    //*********************************各组件开始初始化
	    
	    
	    stocksInit();
	    grailsInit();
	}
	
	private void stocksInit(){
		ReadStocks_resolved reader=new ReadStocks_resolved();
		ArrayList<String> list=reader.getStocks();
		for(int i=1;i<list.size();i++){
			addStocksBase(list.get(i));
			
		}
		
		
		
	}
	
	private boolean addStocksBase(String str){
		//调用下层方法获取股票数据
		//*************************************************************************************
		StocksBLService bl=new StocksBL();	
		StocksVO stocksvo = null;
		boolean ans=true;
		try {
			stocksvo=bl.addStocks(str);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(stocksvo.getName().equals("none")){
			JOptionPane.showMessageDialog(null, "输入的股票不存在！","", JOptionPane.ERROR_MESSAGE);
			ans=false;
		}
		else{
			
			StockNameGetService NameGet=new NameGetter();
			String name=NameGet.getName(str);
			
			Vector v = new Vector(10);
		   	 v.add(str);
		   	v.add(name);		   	 
		   	 v.add(stocksvo.getDate());
		   	v.add(stocksvo.getOpen());
		   	v.add(stocksvo.getClose());
		   	v.add(stocksvo.getHigh());
		   	v.add(stocksvo.getLow());
		   	v.add(stocksvo.getVolume());
		   	v.add(stocksvo.getTurnover());
			v.add(stocksvo.getPb());
		   	stocksPresentBaseModel.addRow(v);
			
			
			
		}
		
		return ans;
		
	}

	
	private void setStocksDetails(ArrayList<StocksVO> list){
		//清空表格
		int row=stocksPresentDetailsModel.getRowCount();
		for(int k=0;k<row;k++){
			stocksPresentDetailsModel.removeRow(0);
		}
		
		
		
		for(int i=0;i<list.size();i++){
			StocksVO stocksvo=list.get(i);
			
			Vector v = new Vector(8);
			 v.add(stocksvo.getDate());
			   	v.add(stocksvo.getOpen());
			   	v.add(stocksvo.getClose());
			   	v.add(stocksvo.getHigh());
			   	v.add(stocksvo.getLow());
			   	v.add(stocksvo.getVolume());
			   	v.add(stocksvo.getTurnover());
				v.add(stocksvo.getPb());
				stocksPresentDetailsModel.addRow(v);
				
				
				
		}
		
		
		
	}
	
	
	
	private void grailsInit(){
      String today=TimeGetter.getToday();
      String before=TimeGetter.getDayBefore(20);
      GrailsSearchVO VO=new GrailsSearchVO(before,today,0,0,0,0,0,0,0,0);
      setGrailsBase(VO);
      

    }
	
	private void setGrailsBase(GrailsSearchVO VO){
    	 //***********************************************************************************通过下层获取信息
        //ArrayList<GrailsVO>  getGrails(VO)
		GrailsBLService bl=new GrailsBL();
		ArrayList<GrailsVO> list=null;
		try {
			list=bl.getGrails(VO);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//以下先清空表格的数据
    	while(grailsPresentBaseModel.getRowCount()>0){
    		grailsPresentBaseModel.removeRow(grailsPresentBaseModel.getRowCount()-1);
    	}
    	
    	//再添加表格的内容
    	for(int i=0;i<list.size();i++){
    		Vector v = new Vector(5);
    		GrailsVO tempVO=list.get(i);
    		
    		
   	   	v.add(tempVO.getdate());
   	   	v.add(tempVO.getopen());
   	   	v.add(tempVO.getclose());
   	   	v.add(tempVO.gethigh());
   	   	v.add(tempVO.getlow());
   	   	
   	   	grailsPresentBaseModel.addRow(v);

    		
    	}
    	
    	
    	
    	
    	
    }
	


    private void buttonSet(JButton btnNewButton,String img){
    	 btnNewButton.setBackground(new Color(255,255,255));  
 	    btnNewButton.setBorder(null); 
 	    btnNewButton.setOpaque(false);
 	   Icon stockWatch=new ImageIcon(img);
	    btnNewButton.setIcon(stockWatch);
    	
    	
    	
    }
    private void buttonSet(JButton btnNewButton){
   	 btnNewButton.setBackground(new Color(255,255,255));  
	    btnNewButton.setBorder(null); 
	    btnNewButton.setOpaque(false);
	  
   	
   	
   	
   }
    }
