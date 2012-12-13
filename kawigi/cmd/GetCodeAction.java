package kawigi.cmd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import kawigi.KawigiEdit;

/**
 *	View submitting code (after it has been UCCed)
 **/
@SuppressWarnings("serial")
public final class GetCodeAction extends DefaultAction {
	private GetCodeDialog dialog = null;
	
	public GetCodeAction(ActID cmdid) {
		super(cmdid);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dialog == null) {
			dialog = new GetCodeDialog();
		}else {
			dialog.setVisible(true);
		}
		dialog.setCode(GetSource.getInstance().getSource());
	}
}

@SuppressWarnings("serial")
class GetCodeDialog extends JDialog {
	private JTextPane textArea;
	
	GetCodeDialog(){
		super((JFrame)null, "get code", true);
		JPanel panel = new JPanel(new BorderLayout());
		textArea = new JTextPane();
		panel.add(new JScrollPane(textArea));
		setContentPane(panel);
		setSize(500, 300);
		setModalityType(ModalityType.MODELESS);
		setVisible(true);
	}
	
	void setCode(String s) {
		textArea.setText(s);
	}
}
