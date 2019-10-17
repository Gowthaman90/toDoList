import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoList
{
    List<TaskItem> taskItemList = new ArrayList<TaskItem>();
    Scanner input = new Scanner(System.in);
    public ToDoList()
    {
        taskItemList.add(new TaskItem(" Project1 ", " Task1 ", " ### To Learn Java   ", LocalDate.now(), "Done"));
        taskItemList.add(new TaskItem(" Project2 ", " Task1 ", " ### To Write program in Java   ", LocalDate.now(), "Done"));
        //taskItemList.add(new TaskItem( projectName: " Project3 ", taskName: " Task3 ", taskDescription: " *** To Write Class in Java    ", LocalDate.now(), taskStatus: "Remove"));
        taskItemList.add(new TaskItem(" Project1 ", " Task2 ", " ### To push code to github   ", LocalDate.now(), "In process"));
    }
    public void showAll() {
        for (int i =0; i < taskItemList.size(); i++) {
            System.out.println(i + " " + taskItemList.get(i));
        }
    }
    public void showByDate() {
        Collections.sort(taskItemList);
        showAll();
    }
    public void showByProject2(){
        //group by project
        Map<String, List<TaskItem>> groupByProjectMap =
                taskItemList.stream().collect( Collectors.groupingBy(TaskItem::getProjectName));
        System.out.println(groupByProjectMap);
    }
    public void showByProject(){
        //Sort by project
        List<TaskItem> sortedList = taskItemList.stream()
                .sorted(Comparator.comparing(TaskItem::getProjectName))
                .collect(Collectors.toList());
        for (TaskItem task: sortedList)
        {
            System.out.println(task);
        }
    }
    public void addNewTask () throws ParseException {
        TaskItem taskItem = new TaskItem();
        System.out.println("Enter project name : ");
        taskItem.setProjectName(input.nextLine()) ;
        System.out.println("Enter task name : ");
        taskItem.setTaskName(input.nextLine());
        System.out.println("Enter task description : ");
        taskItem.setTaskDescription(input.nextLine());
        System.out.println("Enter task date as dd-mm-yyyy: ");
        taskItem.setTaskDate(convertStringToDate(input.nextLine()));
        System.out.println("Enter task status : ");
        taskItem.setTaskStatus(input.nextLine());
        taskItemList.add(taskItem);
        for (TaskItem taskItem1: taskItemList){
            System.out.println(taskItem1);
        }
    }
    // convert taskDate As string to taskDate As Date
    public LocalDate convertStringToDate(String dateString)
    {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        while(true)
//        {
            try{
                date = LocalDate.parse(dateString, formatter);
                System.out.print(date);
                return date;
            }
            catch ( Exception e ){
                System.out.print("Invalid date. Please try again.");
//                dateString = input.nextLine();
                return null;
            }
//        }
    }
}