/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimingDPackage.java,v 1.2 2008/09/07 11:01:21 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.timing.model.timingd;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDFactory
 * @model kind="package"
 * @generated
 */
public interface TimingDPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "timingd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/mdt/uml2tools/timing-diagram/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uml2t.timingd";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingDPackage eINSTANCE = org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameContainerImpl <em>DFrame Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameContainerImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDFrameContainer()
	 * @generated
	 */
	int DFRAME_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Pakkage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME_CONTAINER__PAKKAGE = 0;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME_CONTAINER__FRAMES = 1;

	/**
	 * The number of structural features of the '<em>DFrame Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl <em>DFrame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDFrame()
	 * @generated
	 */
	int DFRAME = 1;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME__INTERACTION = 0;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME__DISPLAY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME__BLOCKS = 2;

	/**
	 * The feature id for the '<em><b>Intervals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME__INTERVALS = 3;

	/**
	 * The number of structural features of the '<em>DFrame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFRAME_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DBlockImpl <em>DBlock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DBlockImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDBlock()
	 * @generated
	 */
	int DBLOCK = 2;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__LIFELINE = 0;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__FRAME = 1;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__DISPLAY_NAME = 2;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__STATES = 3;

	/**
	 * The feature id for the '<em><b>Switches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__SWITCHES = 4;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK__CONSTRAINT = 5;

	/**
	 * The number of structural features of the '<em>DBlock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DBLOCK_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DValueLineImpl <em>DValue Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DValueLineImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDValueLine()
	 * @generated
	 */
	int DVALUE_LINE = 3;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVALUE_LINE__BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Invariant Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVALUE_LINE__INVARIANT_TEMPLATE = 1;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVALUE_LINE__SEGMENTS = 2;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVALUE_LINE__DISPLAY_NAME = 3;

	/**
	 * The number of structural features of the '<em>DValue Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DVALUE_LINE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentImpl <em>DSegment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegment()
	 * @generated
	 */
	int DSEGMENT = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT__STATE = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT__START = 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT__END = 2;

	/**
	 * The feature id for the '<em><b>Middle Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT__MIDDLE_POINTS = 3;

	/**
	 * The feature id for the '<em><b>End Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT__END_SWITCH = 4;

	/**
	 * The number of structural features of the '<em>DSegment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentElementImpl <em>DSegment Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentElementImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentElement()
	 * @generated
	 */
	int DSEGMENT_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_ELEMENT__OCCURRENCE = 0;

	/**
	 * The feature id for the '<em><b>Debug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_ELEMENT__DEBUG_ID = 1;

	/**
	 * The number of structural features of the '<em>DSegment Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentMiddlePointImpl <em>DSegment Middle Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentMiddlePointImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentMiddlePoint()
	 * @generated
	 */
	int DSEGMENT_MIDDLE_POINT = 6;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_MIDDLE_POINT__OCCURRENCE = DSEGMENT_ELEMENT__OCCURRENCE;

	/**
	 * The feature id for the '<em><b>Debug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_MIDDLE_POINT__DEBUG_ID = DSEGMENT_ELEMENT__DEBUG_ID;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_MIDDLE_POINT__SEGMENT = DSEGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DSegment Middle Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_MIDDLE_POINT_FEATURE_COUNT = DSEGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentStartImpl <em>DSegment Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentStartImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentStart()
	 * @generated
	 */
	int DSEGMENT_START = 7;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_START__OCCURRENCE = DSEGMENT_ELEMENT__OCCURRENCE;

	/**
	 * The feature id for the '<em><b>Debug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_START__DEBUG_ID = DSEGMENT_ELEMENT__DEBUG_ID;

	/**
	 * The feature id for the '<em><b>State Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_START__STATE_INVARIANT = DSEGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_START__SEGMENT = DSEGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSegment Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_START_FEATURE_COUNT = DSEGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentEndImpl <em>DSegment End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentEndImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentEnd()
	 * @generated
	 */
	int DSEGMENT_END = 8;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_END__OCCURRENCE = DSEGMENT_ELEMENT__OCCURRENCE;

	/**
	 * The feature id for the '<em><b>Debug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_END__DEBUG_ID = DSEGMENT_ELEMENT__DEBUG_ID;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_END__SEGMENT = DSEGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_END__SWITCH = DSEGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSegment End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSEGMENT_END_FEATURE_COUNT = DSEGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DStateSwitchImpl <em>DState Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DStateSwitchImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDStateSwitch()
	 * @generated
	 */
	int DSTATE_SWITCH = 9;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__OCCURRENCE = DSEGMENT_ELEMENT__OCCURRENCE;

	/**
	 * The feature id for the '<em><b>Debug Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__DEBUG_ID = DSEGMENT_ELEMENT__DEBUG_ID;

	/**
	 * The feature id for the '<em><b>From Segment End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__FROM_SEGMENT_END = DSEGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Segment Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__TO_SEGMENT_START = DSEGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__FROM_SEGMENT = DSEGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>To Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__TO_SEGMENT = DSEGMENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>From Value Line</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__FROM_VALUE_LINE = DSEGMENT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>To Value Line</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH__TO_VALUE_LINE = DSEGMENT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>DState Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSTATE_SWITCH_FEATURE_COUNT = DSEGMENT_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DIntervalImpl <em>DInterval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DIntervalImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDInterval()
	 * @generated
	 */
	int DINTERVAL = 10;

	/**
	 * The feature id for the '<em><b>From Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DINTERVAL__FROM_POINT = 0;

	/**
	 * The feature id for the '<em><b>To Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DINTERVAL__TO_POINT = 1;

	/**
	 * The number of structural features of the '<em>DInterval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DINTERVAL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DPointConstraintImpl <em>DPoint Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DPointConstraintImpl
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDPointConstraint()
	 * @generated
	 */
	int DPOINT_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPOINT_CONSTRAINT__CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Constrainted Segment Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPOINT_CONSTRAINT__CONSTRAINTED_SEGMENT_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>DPoint Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPOINT_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.Constraint <em>UML Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Constraint
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLConstraint()
	 * @generated
	 */
	int UML_CONSTRAINT = 12;

	/**
	 * The number of structural features of the '<em>UML Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.StateInvariant <em>UML State Invariant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.StateInvariant
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLStateInvariant()
	 * @generated
	 */
	int UML_STATE_INVARIANT = 13;

	/**
	 * The number of structural features of the '<em>UML State Invariant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_STATE_INVARIANT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.Interaction <em>UML Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Interaction
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLInteraction()
	 * @generated
	 */
	int UML_INTERACTION = 14;

	/**
	 * The number of structural features of the '<em>UML Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.Package <em>UML Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Package
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLPackage()
	 * @generated
	 */
	int UML_PACKAGE = 15;

	/**
	 * The number of structural features of the '<em>UML Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.Lifeline <em>UML Lifeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Lifeline
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLLifeline()
	 * @generated
	 */
	int UML_LIFELINE = 16;

	/**
	 * The number of structural features of the '<em>UML Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_LIFELINE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.uml2.uml.OccurrenceSpecification <em>UML Occurrence Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.OccurrenceSpecification
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLOccurrenceSpecification()
	 * @generated
	 */
	int UML_OCCURRENCE_SPECIFICATION = 17;

	/**
	 * The number of structural features of the '<em>UML Occurrence Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_OCCURRENCE_SPECIFICATION_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer <em>DFrame Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFrame Container</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer
	 * @generated
	 */
	EClass getDFrameContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getPakkage <em>Pakkage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pakkage</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getPakkage()
	 * @see #getDFrameContainer()
	 * @generated
	 */
	EReference getDFrameContainer_Pakkage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Frames</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getFrames()
	 * @see #getDFrameContainer()
	 * @generated
	 */
	EReference getDFrameContainer_Frames();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame <em>DFrame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFrame</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrame
	 * @generated
	 */
	EClass getDFrame();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interaction</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getInteraction()
	 * @see #getDFrame()
	 * @generated
	 */
	EReference getDFrame_Interaction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getDisplayName()
	 * @see #getDFrame()
	 * @generated
	 */
	EAttribute getDFrame_DisplayName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getBlocks()
	 * @see #getDFrame()
	 * @generated
	 */
	EReference getDFrame_Blocks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getIntervals <em>Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intervals</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getIntervals()
	 * @see #getDFrame()
	 * @generated
	 */
	EReference getDFrame_Intervals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock <em>DBlock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DBlock</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock
	 * @generated
	 */
	EClass getDBlock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lifeline</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getLifeline()
	 * @see #getDBlock()
	 * @generated
	 */
	EReference getDBlock_Lifeline();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Frame</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getFrame()
	 * @see #getDBlock()
	 * @generated
	 */
	EReference getDBlock_Frame();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getDisplayName()
	 * @see #getDBlock()
	 * @generated
	 */
	EAttribute getDBlock_DisplayName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getStates()
	 * @see #getDBlock()
	 * @generated
	 */
	EReference getDBlock_States();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getSwitches <em>Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Switches</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getSwitches()
	 * @see #getDBlock()
	 * @generated
	 */
	EReference getDBlock_Switches();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getConstraint()
	 * @see #getDBlock()
	 * @generated
	 */
	EReference getDBlock_Constraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine <em>DValue Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DValue Line</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DValueLine
	 * @generated
	 */
	EClass getDValueLine();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getBlock()
	 * @see #getDValueLine()
	 * @generated
	 */
	EReference getDValueLine_Block();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getInvariantTemplate <em>Invariant Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invariant Template</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getInvariantTemplate()
	 * @see #getDValueLine()
	 * @generated
	 */
	EReference getDValueLine_InvariantTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segments</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getSegments()
	 * @see #getDValueLine()
	 * @generated
	 */
	EReference getDValueLine_Segments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DValueLine#getDisplayName()
	 * @see #getDValueLine()
	 * @generated
	 */
	EAttribute getDValueLine_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment <em>DSegment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSegment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment
	 * @generated
	 */
	EClass getDSegment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getState()
	 * @see #getDSegment()
	 * @generated
	 */
	EReference getDSegment_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getStart()
	 * @see #getDSegment()
	 * @generated
	 */
	EReference getDSegment_Start();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getEnd()
	 * @see #getDSegment()
	 * @generated
	 */
	EReference getDSegment_End();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getMiddlePoints <em>Middle Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Middle Points</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getMiddlePoints()
	 * @see #getDSegment()
	 * @generated
	 */
	EReference getDSegment_MiddlePoints();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getEndSwitch <em>End Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Switch</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegment#getEndSwitch()
	 * @see #getDSegment()
	 * @generated
	 */
	EReference getDSegment_EndSwitch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement <em>DSegment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSegment Element</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement
	 * @generated
	 */
	EClass getDSegmentElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Occurrence</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement#getOccurrence()
	 * @see #getDSegmentElement()
	 * @generated
	 */
	EReference getDSegmentElement_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement#getDebugId <em>Debug Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Id</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement#getDebugId()
	 * @see #getDSegmentElement()
	 * @generated
	 */
	EAttribute getDSegmentElement_DebugId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint <em>DSegment Middle Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSegment Middle Point</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint
	 * @generated
	 */
	EClass getDSegmentMiddlePoint();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Segment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint#getSegment()
	 * @see #getDSegmentMiddlePoint()
	 * @generated
	 */
	EReference getDSegmentMiddlePoint_Segment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart <em>DSegment Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSegment Start</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart
	 * @generated
	 */
	EClass getDSegmentStart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart#getStateInvariant <em>State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Invariant</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart#getStateInvariant()
	 * @see #getDSegmentStart()
	 * @generated
	 */
	EReference getDSegmentStart_StateInvariant();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Segment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart#getSegment()
	 * @see #getDSegmentStart()
	 * @generated
	 */
	EReference getDSegmentStart_Segment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd <em>DSegment End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSegment End</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd
	 * @generated
	 */
	EClass getDSegmentEnd();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Segment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd#getSegment()
	 * @see #getDSegmentEnd()
	 * @generated
	 */
	EReference getDSegmentEnd_Segment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Switch</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd#getSwitch()
	 * @see #getDSegmentEnd()
	 * @generated
	 */
	EReference getDSegmentEnd_Switch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch <em>DState Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DState Switch</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch
	 * @generated
	 */
	EClass getDStateSwitch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromSegmentEnd <em>From Segment End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Segment End</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromSegmentEnd()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_FromSegmentEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToSegmentStart <em>To Segment Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Segment Start</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToSegmentStart()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_ToSegmentStart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromSegment <em>From Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Segment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromSegment()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_FromSegment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToSegment <em>To Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Segment</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToSegment()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_ToSegment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromValueLine <em>From Value Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Value Line</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getFromValueLine()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_FromValueLine();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToValueLine <em>To Value Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Value Line</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch#getToValueLine()
	 * @see #getDStateSwitch()
	 * @generated
	 */
	EReference getDStateSwitch_ToValueLine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval <em>DInterval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DInterval</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DInterval
	 * @generated
	 */
	EClass getDInterval();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getFromPoint <em>From Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Point</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getFromPoint()
	 * @see #getDInterval()
	 * @generated
	 */
	EReference getDInterval_FromPoint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getToPoint <em>To Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Point</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getToPoint()
	 * @see #getDInterval()
	 * @generated
	 */
	EReference getDInterval_ToPoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint <em>DPoint Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DPoint Constraint</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint
	 * @generated
	 */
	EClass getDPointConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint#getConstraint()
	 * @see #getDPointConstraint()
	 * @generated
	 */
	EReference getDPointConstraint_Constraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint#getConstraintedSegmentElement <em>Constrainted Segment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constrainted Segment Element</em>'.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint#getConstraintedSegmentElement()
	 * @see #getDPointConstraint()
	 * @generated
	 */
	EReference getDPointConstraint_ConstraintedSegmentElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.Constraint <em>UML Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Constraint</em>'.
	 * @see org.eclipse.uml2.uml.Constraint
	 * @model instanceClass="org.eclipse.uml2.uml.Constraint"
	 * @generated
	 */
	EClass getUMLConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.StateInvariant <em>UML State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML State Invariant</em>'.
	 * @see org.eclipse.uml2.uml.StateInvariant
	 * @model instanceClass="org.eclipse.uml2.uml.StateInvariant"
	 * @generated
	 */
	EClass getUMLStateInvariant();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.Interaction <em>UML Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Interaction</em>'.
	 * @see org.eclipse.uml2.uml.Interaction
	 * @model instanceClass="org.eclipse.uml2.uml.Interaction"
	 * @generated
	 */
	EClass getUMLInteraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.Package <em>UML Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Package</em>'.
	 * @see org.eclipse.uml2.uml.Package
	 * @model instanceClass="org.eclipse.uml2.uml.Package"
	 * @generated
	 */
	EClass getUMLPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.Lifeline <em>UML Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Lifeline</em>'.
	 * @see org.eclipse.uml2.uml.Lifeline
	 * @model instanceClass="org.eclipse.uml2.uml.Lifeline"
	 * @generated
	 */
	EClass getUMLLifeline();

	/**
	 * Returns the meta object for class '{@link org.eclipse.uml2.uml.OccurrenceSpecification <em>UML Occurrence Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Occurrence Specification</em>'.
	 * @see org.eclipse.uml2.uml.OccurrenceSpecification
	 * @model instanceClass="org.eclipse.uml2.uml.OccurrenceSpecification"
	 * @generated
	 */
	EClass getUMLOccurrenceSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimingDFactory getTimingDFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameContainerImpl <em>DFrame Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameContainerImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDFrameContainer()
		 * @generated
		 */
		EClass DFRAME_CONTAINER = eINSTANCE.getDFrameContainer();

		/**
		 * The meta object literal for the '<em><b>Pakkage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFRAME_CONTAINER__PAKKAGE = eINSTANCE.getDFrameContainer_Pakkage();

		/**
		 * The meta object literal for the '<em><b>Frames</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFRAME_CONTAINER__FRAMES = eINSTANCE.getDFrameContainer_Frames();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl <em>DFrame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDFrame()
		 * @generated
		 */
		EClass DFRAME = eINSTANCE.getDFrame();

		/**
		 * The meta object literal for the '<em><b>Interaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFRAME__INTERACTION = eINSTANCE.getDFrame_Interaction();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DFRAME__DISPLAY_NAME = eINSTANCE.getDFrame_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFRAME__BLOCKS = eINSTANCE.getDFrame_Blocks();

		/**
		 * The meta object literal for the '<em><b>Intervals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFRAME__INTERVALS = eINSTANCE.getDFrame_Intervals();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DBlockImpl <em>DBlock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DBlockImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDBlock()
		 * @generated
		 */
		EClass DBLOCK = eINSTANCE.getDBlock();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBLOCK__LIFELINE = eINSTANCE.getDBlock_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Frame</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBLOCK__FRAME = eINSTANCE.getDBlock_Frame();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DBLOCK__DISPLAY_NAME = eINSTANCE.getDBlock_DisplayName();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBLOCK__STATES = eINSTANCE.getDBlock_States();

		/**
		 * The meta object literal for the '<em><b>Switches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBLOCK__SWITCHES = eINSTANCE.getDBlock_Switches();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DBLOCK__CONSTRAINT = eINSTANCE.getDBlock_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DValueLineImpl <em>DValue Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DValueLineImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDValueLine()
		 * @generated
		 */
		EClass DVALUE_LINE = eINSTANCE.getDValueLine();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DVALUE_LINE__BLOCK = eINSTANCE.getDValueLine_Block();

		/**
		 * The meta object literal for the '<em><b>Invariant Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DVALUE_LINE__INVARIANT_TEMPLATE = eINSTANCE.getDValueLine_InvariantTemplate();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DVALUE_LINE__SEGMENTS = eINSTANCE.getDValueLine_Segments();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DVALUE_LINE__DISPLAY_NAME = eINSTANCE.getDValueLine_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentImpl <em>DSegment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegment()
		 * @generated
		 */
		EClass DSEGMENT = eINSTANCE.getDSegment();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT__STATE = eINSTANCE.getDSegment_State();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT__START = eINSTANCE.getDSegment_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT__END = eINSTANCE.getDSegment_End();

		/**
		 * The meta object literal for the '<em><b>Middle Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT__MIDDLE_POINTS = eINSTANCE.getDSegment_MiddlePoints();

		/**
		 * The meta object literal for the '<em><b>End Switch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT__END_SWITCH = eINSTANCE.getDSegment_EndSwitch();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentElementImpl <em>DSegment Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentElementImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentElement()
		 * @generated
		 */
		EClass DSEGMENT_ELEMENT = eINSTANCE.getDSegmentElement();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_ELEMENT__OCCURRENCE = eINSTANCE.getDSegmentElement_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Debug Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSEGMENT_ELEMENT__DEBUG_ID = eINSTANCE.getDSegmentElement_DebugId();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentMiddlePointImpl <em>DSegment Middle Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentMiddlePointImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentMiddlePoint()
		 * @generated
		 */
		EClass DSEGMENT_MIDDLE_POINT = eINSTANCE.getDSegmentMiddlePoint();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_MIDDLE_POINT__SEGMENT = eINSTANCE.getDSegmentMiddlePoint_Segment();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentStartImpl <em>DSegment Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentStartImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentStart()
		 * @generated
		 */
		EClass DSEGMENT_START = eINSTANCE.getDSegmentStart();

		/**
		 * The meta object literal for the '<em><b>State Invariant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_START__STATE_INVARIANT = eINSTANCE.getDSegmentStart_StateInvariant();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_START__SEGMENT = eINSTANCE.getDSegmentStart_Segment();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentEndImpl <em>DSegment End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DSegmentEndImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDSegmentEnd()
		 * @generated
		 */
		EClass DSEGMENT_END = eINSTANCE.getDSegmentEnd();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_END__SEGMENT = eINSTANCE.getDSegmentEnd_Segment();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSEGMENT_END__SWITCH = eINSTANCE.getDSegmentEnd_Switch();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DStateSwitchImpl <em>DState Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DStateSwitchImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDStateSwitch()
		 * @generated
		 */
		EClass DSTATE_SWITCH = eINSTANCE.getDStateSwitch();

		/**
		 * The meta object literal for the '<em><b>From Segment End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__FROM_SEGMENT_END = eINSTANCE.getDStateSwitch_FromSegmentEnd();

		/**
		 * The meta object literal for the '<em><b>To Segment Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__TO_SEGMENT_START = eINSTANCE.getDStateSwitch_ToSegmentStart();

		/**
		 * The meta object literal for the '<em><b>From Segment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__FROM_SEGMENT = eINSTANCE.getDStateSwitch_FromSegment();

		/**
		 * The meta object literal for the '<em><b>To Segment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__TO_SEGMENT = eINSTANCE.getDStateSwitch_ToSegment();

		/**
		 * The meta object literal for the '<em><b>From Value Line</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__FROM_VALUE_LINE = eINSTANCE.getDStateSwitch_FromValueLine();

		/**
		 * The meta object literal for the '<em><b>To Value Line</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSTATE_SWITCH__TO_VALUE_LINE = eINSTANCE.getDStateSwitch_ToValueLine();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DIntervalImpl <em>DInterval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DIntervalImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDInterval()
		 * @generated
		 */
		EClass DINTERVAL = eINSTANCE.getDInterval();

		/**
		 * The meta object literal for the '<em><b>From Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DINTERVAL__FROM_POINT = eINSTANCE.getDInterval_FromPoint();

		/**
		 * The meta object literal for the '<em><b>To Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DINTERVAL__TO_POINT = eINSTANCE.getDInterval_ToPoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DPointConstraintImpl <em>DPoint Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.DPointConstraintImpl
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getDPointConstraint()
		 * @generated
		 */
		EClass DPOINT_CONSTRAINT = eINSTANCE.getDPointConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPOINT_CONSTRAINT__CONSTRAINT = eINSTANCE.getDPointConstraint_Constraint();

		/**
		 * The meta object literal for the '<em><b>Constrainted Segment Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPOINT_CONSTRAINT__CONSTRAINTED_SEGMENT_ELEMENT = eINSTANCE.getDPointConstraint_ConstraintedSegmentElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.Constraint <em>UML Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.Constraint
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLConstraint()
		 * @generated
		 */
		EClass UML_CONSTRAINT = eINSTANCE.getUMLConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.StateInvariant <em>UML State Invariant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.StateInvariant
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLStateInvariant()
		 * @generated
		 */
		EClass UML_STATE_INVARIANT = eINSTANCE.getUMLStateInvariant();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.Interaction <em>UML Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.Interaction
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLInteraction()
		 * @generated
		 */
		EClass UML_INTERACTION = eINSTANCE.getUMLInteraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.Package <em>UML Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.Package
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLPackage()
		 * @generated
		 */
		EClass UML_PACKAGE = eINSTANCE.getUMLPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.Lifeline <em>UML Lifeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.Lifeline
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLLifeline()
		 * @generated
		 */
		EClass UML_LIFELINE = eINSTANCE.getUMLLifeline();

		/**
		 * The meta object literal for the '{@link org.eclipse.uml2.uml.OccurrenceSpecification <em>UML Occurrence Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.uml2.uml.OccurrenceSpecification
		 * @see org.eclipse.uml2.diagram.timing.model.timingd.impl.TimingDPackageImpl#getUMLOccurrenceSpecification()
		 * @generated
		 */
		EClass UML_OCCURRENCE_SPECIFICATION = eINSTANCE.getUMLOccurrenceSpecification();

	}

} //TimingDPackage