package org.eclipse.uml2.diagram.sequence.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.uml2.diagram.common.layered.MultiLayeredContainer;
import org.eclipse.uml2.diagram.common.layered.MultilayeredFigure;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupport;
import org.eclipse.uml2.diagram.common.layered.MultilayeredSupportImpl;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramEditorPlugin;

public class StateInvariantShape extends RoundedRectangle implements MultilayeredFigure {
    protected static final int DEFAULT_RADIUS = 15;
    protected static final int VERTICAL_SPACING = 2;

    private final MultilayeredSupportImpl myMultilayeredSupport = new MultilayeredSupportImpl();
    private Label myInplaceLabel;
    
    public StateInvariantShape () {
        setOutline(false);
        setBackgroundColor(ColorConstants.lightGray);
        
        corner.width = DEFAULT_RADIUS;
        corner.height = DEFAULT_RADIUS;
        
        setLayoutManager(new BorderLayout());
        
        int gapWidth = corner.width/2;
        
        myInplaceLabel = new Label("");
        myInplaceLabel.setForegroundColor(ColorConstants.black);
        myInplaceLabel.setFont(UMLDiagramEditorPlugin.getInstance().getDefaultBoldFont());
        myInplaceLabel.setBorder(new MarginBorder(VERTICAL_SPACING,gapWidth,VERTICAL_SPACING,gapWidth));
        myInplaceLabel.setLabelAlignment(PositionConstants.CENTER);
        
        add(myInplaceLabel, BorderLayout.CENTER);
        
        myMultilayeredSupport.setLayerToFigure(MultiLayeredContainer.FOREGROUND_LAYER, this);
        myMultilayeredSupport.setLayerToContentPane(MultiLayeredContainer.FOREGROUND_LAYER, this);
    }
    
	public Label getStateInvariantInplaceLabel() {
		return myInplaceLabel;
	}
    
    public MultilayeredSupport getMultilayeredSupport() {
        return myMultilayeredSupport;
    }
    
}
