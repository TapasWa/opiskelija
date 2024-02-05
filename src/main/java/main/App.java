package main;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        
       

        while (true) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, " +
                    "4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, " +
                    "6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, " +
                    "8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            String StringInput=scanner.nextLine();
            int k = Integer.parseInt(StringInput);

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
                    List<Student> students = university.getStudents();
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println( students.get(i).getStudentNumber() + ": " + students.get(i).getName());
                    }
                    break;


                case 3:
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int studentIndex = scanner.nextInt();
                    scanner.nextLine();  
                    Student selectedStudent = university.getStudents().get(studentIndex);

                    System.out.println("Anna kurssin nimi:");
                    String course = scanner.nextLine();
                    System.out.println("Anna arvosana:");
                    int grade = scanner.nextInt();
                    selectedStudent.addGrade(course, grade);
                    break;


                case 4:
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    int selectedStudentIndex = scanner.nextInt();
                    Student selectedStudentToPrint = university.getStudents().get(selectedStudentIndex);
                    List<Grade> studentGrades = selectedStudentToPrint.getGrades();
                    for (Grade studentGrade : studentGrades) {
                        System.out.println(studentGrade.getCourse() + ": " + studentGrade.getGrade());
                    }
                    break;

                case 5:
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    int studentAverageIndex = scanner.nextInt();
                    Student studentForAverage = university.getStudents().get(studentAverageIndex);
                    double average = Calculator.getAverageGrade(studentForAverage);
                    System.out.println("Keskiarvo on " + average);
                    break;

                case 6:
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    int studentMedianIndex = scanner.nextInt();
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

