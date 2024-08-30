import java.util.Scanner;//підключаємо пакет для використання класу Scanner

public class TaskPlanner
{
    
 public static void main(String[] args)//основний метод "виклику" планувальника завдань на тиждень
 {
    TaskPlanner taskPlanner = new TaskPlanner();//створюємо екземпляр класу TaskPlanner для доступу до методів 
     String[][] schedule = new String[7][2];//створюємо матрицю типу String розміром 7х2
     schedule=taskPlanner.Creating(schedule);//передаємо новостворену матрицю у метод,що заопвнює її і присвоюємо їй значення комірок за замовчуванням
     taskPlanner.MainScript(schedule);//вивкликаємо метод через який буде проводитися взаємодія з планувальником завдань

 }
 public String[][] Creating(String[][] arrString)//метод що заповнює всі комірки планувальника
 {
   arrString[0][0]="Monday";arrString[0][1]="do homework;go to the grocery market";
   arrString[1][0]="Tuesday";arrString[1][1]="go to university;go to courses";
   arrString[2][0]="Wednesday";arrString[2][1]="go to the gym; watch a film";
   arrString[3][0]="Thursday";arrString[3][1]="go on a walk with friends";
   arrString[4][0]="Friday";arrString[4][1]="clean the room; do homework";
   arrString[5][0]="Saturday";arrString[5][1]="goo on a picnic";
   arrString[6][0]="Sunday";arrString[6][1]="prepare to the next week";

   return arrString;//повертаємо  змінену матрицю
 }
 public void MainScript(String[][] weekSchedule)//метод що дозволяє дивитися/змінювати дані планувальника
 {

  boolean flag =false;//булева змінна,що потрібна для  постійної роботи циклу do...while планувальника,допоки користувач не захоче з нього вийти
  do //розпочинаємо цикл do...while
  {
  System.out.println("Please input the day of the week");
  Scanner scanner = new Scanner(System.in);
  String originalInput =scanner.nextLine();//користувач вводить день тижня,який його цікавить/хоче змінити
  String inputtedDay=originalInput.toLowerCase().replace(" ", "");//переводимо оригінально введений рядок до нижнього регістру/прибравши всі пробіли попередньо створивши для цього іншу змінну
  switch (inputtedDay) 
  {
    //виводимо на екран інформацію,що є в планувальнику щодо розпізнаного дня
  case "monday":
    {
        System.out.println("Your tasks for "+ weekSchedule[0][0]+": "+weekSchedule[0][1]);
        break;
    }
  case "tuesday":
    {   System.out.println("Your tasks for "+ weekSchedule[1][0]+": "+weekSchedule[1][1]);
        break;
    }
  case "wednesday":
  {
    System.out.println("Your tasks for "+ weekSchedule[2][0]+": "+weekSchedule[2][1]);
    break;
  }
  case "thursday":
  {
    System.out.println("Your tasks for "+ weekSchedule[3][0]+": "+weekSchedule[3][1]);
    break;
  }
  case "friday":
  {
    System.out.println("Your tasks for "+ weekSchedule[4][0]+": "+weekSchedule[4][1]);
    break;
  }
  case "saturday":
  {
    System.out.println("Your tasks for "+ weekSchedule[5][0]+": "+weekSchedule[5][1]);
    break;
  }
  case "sunday":
  {
    System.out.println("Your tasks for "+ weekSchedule[6][0]+": "+weekSchedule[6][1]);
    break;
  }
  //виходимо з програми,якщо того схотів користувач
  case "exit":
  {
    flag = true;//змінюємо значення булевої змінної,що відповідає за продовження циклу
    break;
  }
    default://день тижня не розпізнано
    { 
      if(originalInput.toLowerCase().contains("change "))//перевіряємо чи оригінальний рядок переведений до нижнього регістру містить "change "
      {
        //якщо так,тоді переходимо до методу Reschedule
        weekSchedule=Reschedule(inputtedDay,weekSchedule,scanner);//присвоюємо поточній матриці планування змінене значення
        break;
      }
      else
      {
        //інашке виводимо на екран,що програма не змогла розпізнати команду користувача
        System.out.println("Sorry,I don't understand you,please try again");
        break;
      }
    }
        
  }
  } while (!flag);//цикл триває,допоки відповідна змінна має значення false
}
public String[][] Reschedule(String changedDay,String[][] schedule,Scanner scan)//метод,що дозволяє змінити заплановані завдання відповідного дня
{
  changedDay=changedDay.replace("change", "");//прибираємо слово change з  введеного користувачем рядка
 switch (changedDay) 
 {
  //просимо користувача ввести нове завдання для відповідно розпізнаного дня,присвоюємо введене значення у відповідну комірку в матриці
  case "monday":
    {
      System.out.println("Input new tasks for "+schedule[0][0]);
      schedule[0][1]=scan.nextLine();
      break;
    }
   case "tuesday":
   {
      System.out.println("Input new tasks for "+schedule[1][0]);
      schedule[1][1]=scan.nextLine();
      break;
   }
   case "wednesday":
   {
      System.out.println("Input new tasks for "+schedule[2][0]);
      schedule[2][1]=scan.nextLine();
      break;
   }
   case "thursday":
   {
      System.out.println("Input new tasks for "+schedule[3][0]);
      schedule[3][1]=scan.nextLine();
      break;
   }
   case "friday":
   {
      System.out.println("Input new tasks for "+schedule[4][0]);
      schedule[4][1]=scan.nextLine();
      break;
   }
   case "saturday":
   {
      System.out.println("Input new tasks for "+schedule[5][0]);
      schedule[5][1]=scan.nextLine();
      break;
   }
   case "sunday":
   {
      System.out.println("Input new tasks for "+schedule[6][0]);
      schedule[6][1]=scan.nextLine();
      break;
   }
   //якщо день не розпізнано виводимо повідомлення,що програма не розпізнала команду користувача
  default:
    {
      System.out.println("Sorry,I don't understand you,please try again");
      break;
    }
 }
 return schedule;//повертаємо значення матриці
}
}
