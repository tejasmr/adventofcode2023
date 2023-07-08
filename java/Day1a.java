import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.io.IOException;

class Property<T> {
  T value;
  
  public Property(T value) {
    this.value = value;
  }

  public void set(T value) {
    this.value = value;
  }

  public T get() {
    return this.value;
  }

  public String toString() {
    return value.toString();
  }
}

public class Day1 {
  private static final String FILE_NAME = "Day1a.txt";
  private static int answer = 0;

  public static void readLines(Consumer<String> consumer) {
    try (
      FileInputStream stream = new FileInputStream(FILE_NAME);
      InputStreamReader inputReader = new InputStreamReader(stream);
      BufferedReader reader = new BufferedReader(inputReader);
    ) {
      
      String line;

      while ((line = reader.readLine()) != null) {
        consumer.accept(line);
      }

    }
    catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public static void main(String[] args) {
    
    Property<Integer> maxSumCalories = new Property<Integer>(0);
    Property<Integer> sumCalories = new Property<Integer>(0);

    // read the file 
    readLines((line) -> {
      if (line.isEmpty()) {
        maxSumCalories.set(Math.max(maxSumCalories.get(), sumCalories.get()));
        sumCalories.set(0);
      }
      else {
        sumCalories.set(sumCalories.get() + Integer.parseInt(line));
      }
    });

    System.out.println(maxSumCalories);

  }
}
