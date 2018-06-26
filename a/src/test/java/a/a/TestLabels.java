package a.a;

import javax.swing.JLabel;

import GUI.LabelsCon;

import junit.framework.TestCase;

public class TestLabels  extends TestCase {
	LabelsCon labels = new LabelsCon();

	protected void setUp() {
		labels.addLabel(new JLabel());
	}

	public void test_labels() {
		assertNotNull(labels.getLabel().next());
	}
}
