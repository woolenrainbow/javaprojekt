package GUI;

import java.util.ArrayList;

import javax.swing.JLabel;

public class LabelsCon implements LabelsContainer{
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	
	public void removeLabels() {
		labels.clear();
	}
	public void addLabel(JLabel l) {
		this.labels.add(l);
	}
	@Override
	public LabelsIterator getLabel() {
		return new LabelsIter();
	}
	
	private class LabelsIter implements LabelsIterator{
		
		int index = 0;
		
		@Override
		public boolean hasnext() {
			if (index < labels.size())
				return true;
			else
				return false;
			}
	
		@Override
		public JLabel next() {
			if(this.hasnext())
				return labels.get(index++);
			return null;
		}
	}
}
