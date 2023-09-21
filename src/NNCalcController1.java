import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Mike Harmeyer
 *
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber top = model.top();
        NaturalNumber bottom = model.bottom();

        //Update the view to the show changes in the model
        view.updateTopDisplay(top);
        view.updateBottomDisplay(bottom);
        //Disable buttons when needed
        view.updateSubtractAllowed(bottom.compareTo(top) <= 0);
        view.updateDivideAllowed(!bottom.isZero());
        view.updateRootAllowed(
                bottom.compareTo(TWO) >= 0 && bottom.compareTo(INT_LIMIT) <= 0);
        view.updatePowerAllowed(bottom.compareTo(TWO) >= 0);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
        //Get aliases for top and bottom
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        //Copy the number to the top
        top.copyFrom(bottom);
        //Update the user view
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {
        //All following operations will create aliases
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Most operations will follow procedure of performing operation on the
         * top and transferring it to the bottom
         */
        top.add(bottom);
        bottom.transferFrom(top);
        //Update view for the user
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSubtractEvent() {
        //Same logic as proccessAddEvent
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.subtract(bottom);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {
        //Same logic as proccessAddEvent
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        top.multiply(bottom);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {
        //Same logic with slight tweaks
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        //Create a new natural number to store remainder
        NaturalNumber rem = top.divide(bottom);
        bottom.transferFrom(top);
        //Display remainder on top screen
        top.transferFrom(rem);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {
        //Same logic with slight changes
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        //Create int in order to use power method
        int pow = bottom.toInt();
        top.power(pow);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {
        //Same logic as processPowerEvent
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        int r = bottom.toInt();
        top.root(r);
        bottom.transferFrom(top);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {
        //Alias bottom
        NaturalNumber bottom = this.model.bottom();
        //Use multiplyBy10 method to add desired digit
        bottom.multiplyBy10(digit);
        updateViewToMatchModel(this.model, this.view);
    }

}
