package stickman.view;

import java.util.HashSet;
import java.util.Set;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import stickman.model.GameEngine;

class KeyboardInputHandler {
  private final GameEngine model;
  private boolean left = false;
  private boolean right = false;
  private Set<KeyCode> pressedKeys = new HashSet<>();
  private CareTaker careTaker = new CareTaker();
  private boolean pressedSaved = false;

  KeyboardInputHandler(GameEngine model) {
    this.model = model;
  }

  void handlePressed(KeyEvent keyEvent) {


    KeyCode code = keyEvent.getCode();
    if (pressedKeys.contains(code)) {
      return;
    }
    pressedKeys.add(code);

    switch (code) {
      case S:
        break;
      case R:
        break;
      case UP:
        model.jump();
        break;
      case LEFT:
        left = true;
        break;
      case RIGHT:
        right = true;
        break;
      default:
        return;
    }

    moveModel();
  }

  void handleReleased(KeyEvent keyEvent) {
    KeyCode code = keyEvent.getCode();
    pressedKeys.remove(code);

    switch (code) {
      case S:
        careTaker.setMemento(model.save());
        pressedSaved = true;
        return;
      case R:
        if (pressedSaved){
          model.restore(careTaker.get());
          pressedSaved = false;
        }
        return;
      case LEFT:
        left = false;
        break;
      case RIGHT:
        right = false;
        break;
      default:
        return;
    }
    moveModel();
  }

  private void moveModel() {
    // If they're both true or both false, I was going to do ~(a ^ b)
    // or (left == true && right == true) || (left == false && right == false)
    // but they're logically equivalent  and left == right is the most compact
    if (left == right) {
      model.stopMoving();
    } else if (right) {
      model.moveRight();
    } else if (left) {
      model.moveLeft();
    }
  }
}
