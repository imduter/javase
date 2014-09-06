package com.dreateam.app.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 * @description TODO
 * @author zcloud
 * @date 2014年2月12日
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	//menuBar
	private JMenuBar mMenuBar;
	private JMenu fileM;
	private JMenu editM;
	private JMenu searchM;
	private JMenu aboutM;
	private Action openAct;
	private Action newFileAct;
	//toolBar
	private JToolBar mToolBar;
	//main
	private JTabbedPane mTabPane;
	//info area
	private JScrollPane infoScrollPane;
	private JTextArea infoTa;
	//spliter
	private JSplitPane info_main_spliter;
	private FileChooser fChooser;
	private File selectedFile;
	
	
	MainFrame(String title)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		initFrame();
	}
	
	private void initFrame()
	{
		mTabPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		
		
		infoTa = new JTextArea("文件大小\n文件创建日期");
		infoTa.setEditable(false);
		infoScrollPane = new JScrollPane(infoTa);
		info_main_spliter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, infoScrollPane, mTabPane);
		info_main_spliter.setDividerSize(5);
		info_main_spliter.setDividerLocation(200);

		add(info_main_spliter);
		initActions();
		initMenuBar();
		initToolBar();
		setJMenuBar(mMenuBar);
		add(BorderLayout.NORTH, mToolBar);
		pack();
	}
	
	private void initToolBar()
	{
		mToolBar = new JToolBar();
		mToolBar.add(newFileAct);
	}

	private void initActions()
	{
		openAct = new AbstractAction("打开")
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openFile();
			}
		};
	}

	private void openFile()
	{
		fChooser = new FileChooser("/");
		fChooser.showOpenDialog(this);
	}
	
	private void initMenuBar()
	{
		fileM = new JMenu("文件");
		editM = new JMenu("编辑");
		searchM = new JMenu("搜索");
		aboutM = new JMenu("关于");
		
		fileM.add(openAct).setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));;
		
		
		mMenuBar = new JMenuBar();
		mMenuBar.add(fileM);
		mMenuBar.add(editM);
		mMenuBar.add(searchM);
		mMenuBar.add(aboutM);
	}
	
	private class FileChooser extends JFileChooser
	{
		public FileChooser(String path)
		{
			super(path);
		}

		@Override
		public void approveSelection()
		{
			selectedFile = getSelectedFile();
			HexEditPane hep = new HexEditPane(selectedFile);
			JScrollPane jsp = new JScrollPane(hep);
			mTabPane.add(selectedFile.getAbsolutePath(), jsp);
			super.approveSelection();
		}
	}
	
}
