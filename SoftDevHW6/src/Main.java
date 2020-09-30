/*
 * @author jguedel
 * @version 1.0
 * 
 */
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Composite {
	
	/** The File name. */
	private Text FileName;
	
	/** The ans. */
	private Text ans;
	
	/** The selected file. */
	private File selectedFile;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Main LOC = new Main(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	/**
	 * Create the composite.
	 *
	 * @param parent the parent
	 * @param style  the style
	 */
	public Main(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		Label lblCountingFromFile = new Label(this, SWT.NONE);
		lblCountingFromFile.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.BOLD));
		lblCountingFromFile.setBounds(81, 0, 288, 49);
		lblCountingFromFile.setText("Counting From File");

		FileName = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		FileName.setTouchEnabled(true);
		FileName.setText("File Name");
		FileName.setBounds(91, 55, 278, 19);

		Button btnGetFile = new Button(this, SWT.NONE);
		btnGetFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					// System.out.println(selectedFile.getAbsolutePath());
					FileName.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnGetFile.setBounds(101, 85, 70, 21);
		btnGetFile.setText("Get File");

		Button btnCountFile = new Button(this, SWT.NONE);
		btnCountFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try {
					inputs.file(selectedFile);
					ans.setText("The number of lines without comments are: " + Integer.toString(inputs.getLoc()) + "\n"
							+ inputs.getLoops());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCountFile.setBounds(291, 85, 70, 21);
		btnCountFile.setText("Count File");

		ans = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		ans.setTouchEnabled(true);
		ans.setBounds(91, 153, 278, 122);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Composite#checkSubclass()
	 */
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
