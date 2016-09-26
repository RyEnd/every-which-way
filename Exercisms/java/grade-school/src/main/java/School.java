import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class School {
  private Map<Integer, List<String>> db;

  public School() {
  	db = new HashMap<>();
  }

  public Map<Integer, List<String>> db() {
  	return db;
  }

  public void add(String student, int grade) {
  	List<String> students;
    if (db.containsKey(grade)) {
      students = db.get(grade);
    } else {
      students = new ArrayList<String>();
    }

    students.add(student);
    db.put(grade, students);
  }

  public List<String> grade(int grade) {
  	if (!db.containsKey(grade)){
  	  return Collections.<String>emptyList();
  	}
  	return db.get(grade);
  }

  public Map<Integer, List<String>> sort() {
  	for(List<String> students: db.values()) {
  	  Collections.sort(students);
  	}
  	return db;
  }
}