package hw4.shop.command;

/**
 * A simple command interface.
 */
public interface Command {
  /**
   * The command body.
   * @return true if command succeeds, false otherwise
   */
  public boolean run ();
}
