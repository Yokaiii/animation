package cs3500.animator.views;

public interface IView {

  /**
   * Make the view visible
   */
  void makeVisible();

  /**
   * Refresh the view
   */
  void refresh();

  /**
   * Shows error message
   */
  void showErrorMessage(String error);

  void go();
}
