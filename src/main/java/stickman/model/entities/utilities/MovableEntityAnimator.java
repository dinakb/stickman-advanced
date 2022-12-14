package stickman.model.entities.utilities;

import stickman.model.entities.MovableEntity;
import stickman.model.entities.character.movementStrategies.MovementStrategy;

/**
 * Animates movable entities. The design of this is somewhat inspired by the state pattern. You may
 * imagine each frame in an animation as a state. However as part of this is time based and given
 * that there maybe be a lot of states it is simpler not following the state design pattern to a
 * tee, which would add unnecessary complexity to this class and its usage.
 */
public class MovableEntityAnimator {
  private static final int RATE = 30;
  private int index = 0;
  private String[] imagePaths;
  private MovableEntity movableEntity;

  public MovableEntityAnimator(String[] imagePaths, MovableEntity movableEntity) {
    this.imagePaths = imagePaths;
    this.movableEntity = movableEntity;
  }


  /** Set the image path for the entity */
  public void setNextFrame() {
    movableEntity.setImagePath(imagePaths[(index / RATE) % imagePaths.length]);
    index++;
  }

  public void setImagePaths(String[] imagePaths) {
    this.imagePaths = imagePaths;
  }

  public String[] getImagePaths (){
    return imagePaths;
  }

  public MovableEntity getMovableEntity (){
    return movableEntity;
  }

  public void setMovableEntity (MovableEntity movableEntity){
    this.movableEntity = movableEntity;
  }
}
