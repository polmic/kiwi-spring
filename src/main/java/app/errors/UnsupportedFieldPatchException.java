package app.errors;

import java.util.Set;

public class UnsupportedFieldPatchException extends RuntimeException {
  public UnsupportedFieldPatchException(Set<String> keySet) {
    super("Unsupported data for operation: " + keySet.toString());
  }
}
