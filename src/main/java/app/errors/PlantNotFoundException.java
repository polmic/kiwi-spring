package app.errors;

public class PlantNotFoundException extends RuntimeException {

  public PlantNotFoundException(Long id) {
    super("plant not found : " + id);
  }

}