package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://5.196.7.235:8000/examples/firebase-angular/#/")
public class ToDoMvcPage extends PageObject {
    public static final Target HEADER = Target.the("Page header").locatedBy("//header/h1");

    public static final Target TODO_INPUT = Target.the("Input for todo-items").locatedBy("//input[contains(@class,'new-todo')]");

    public static final Target ALL_TODO_ITEMS = Target.the("Added todo items").locatedBy("//label[@class='ng-binding']");

    public static final Target COMPLETED_TODO_ITEMS = Target.the("Todo items marked as 'Completed'").locatedBy("//li[@class='ng-scope completed']//label[@class='ng-binding']");

    public static final Target ACTIVE_TODO_ITEMS = Target.the("Todo items marked as 'Completed'").locatedBy("//li[@class='ng-scope']//label[@class='ng-binding']");

    public static Target getCompletedCheckboxForItem(String item){
        return Target.the("'Completed' checkbox for '" + item + "' item").locatedBy("//label[text()='"+item+"']/preceding-sibling::input[@type='checkbox']");
    }

    public static Target getDeleteButtonForItem(String item){
        return Target.the("'Delete' button for '" + item + "' item").locatedBy("//label[text()='"+item+"']/following-sibling::button[@class='destroy']");
    }

    public static Target getItem(String item){
        return Target.the("Item '" + item + "'").locatedBy("//ul[@class='todo-list']//label[text()='"+item+"']");
    }
}
