package main;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        int students;

        while (true) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, " +
                    "4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, " +
                    "6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, " +
                    "8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            int k = Integer.parseInt(scanner.nextLine());

            switch (k) {
                case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = scanner.nextLine();
                    Student newStudent = new Student(name, studentNumber);
                    university.addStudent(newStudent);
                    break;

                case 2:
                    System.out.println("Opiskelijat:");
                    List<Student> studentsList = university.getStudents();
                    for (int i = 0; i < studentsList.size(); i++) {
                        System.out.println(studentsList.get(i).getStudentNumber() + ": " + studentsList.get(i).getName());
                    }
                    break;

                case 3:
                    List<Student> studentsList2 = university.getStudents();
                    for (int i = 0; i < studentsList2.size(); i++) {
                        System.out.println(i + ": " + studentsList2.get(i).getName());
                    }
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    
                    
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    
                    Student selectedStudent = university.getStudents().get(studentIndex);

                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = scanner.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = Integer.parseInt(scanner.nextLine());
                    selectedStudent.addGrade(course, grade);
                    break;

                case 4:
                    List<Student> studentsList3 = university.getStudents();
                    for (int i = 0; i < studentsList3.size(); i++) {
                    System.out.println(i + ": " + studentsList3.get(i).getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    
                    int selectedStudentIndex = Integer.parseInt(scanner.nextLine());
                    Student selectedStudentToPrint = university.getStudents().get(selectedStudentIndex);
                    List<Grade> studentGrades = selectedStudentToPrint.getGrades();
                    for (Grade studentGrade : studentGrades) {
                        System.out.println(studentGrade.getCourse() + ": " + studentGrade.getGrade());
                    }
                    break;

                case 5:
                    List<Student> studentsList4 = university.getStudents();
                    for (int i = 0; i < studentsList4.size(); i++) {
                    System.out.println(i + ": " + studentsList4.get(i).getName());
                     }
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    
                    int studentAverageIndex = Integer.parseInt(scanner.nextLine());
                    Student studentForAverage = university.getStudents().get(studentAverageIndex);
                    double average = Calculator.getAverageGrade(studentForAverage);
                    System.out.println("Keskiarvo on " + average);
                    break;

                case 6:
                    List<Student> studentsList5 = university.getStudents();
                    for (int i = 0; i < studentsList5.size(); i++) {
                    System.out.println(i + ": " + studentsList5.get(i).getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    
                    int studentMedianIndex = Integer.parseInt(scanner.nextLine());
                    Student studentForMedian = university.getStudents().get(studentMedianIndex);
                    double median = Calculator.getMedianGrade(studentForMedian);
                    System.out.println("Mediaani on " + median);
                    break;

                case 7:
                    university.saveToFile("students.txt");
                    break;

                case 8:
                    University loadedUniversity = University.loadFromFile("students.txt");
                    if (loadedUniversity != null) {
                        university = loadedUniversity;
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Syöte oli väärä.");
            }
        }
    }
}

