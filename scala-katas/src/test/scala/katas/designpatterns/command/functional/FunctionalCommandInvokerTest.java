package katas.designpatterns.command.functional;

import katas.designpatterns.command.oo.Dinner;
import katas.designpatterns.command.oo.Lunch;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.function.Consumer;

import static org.junit.Assert.*;

/**
 *
 */
public class FunctionalCommandInvokerTest {


    @Test
    public void shouldInvokeDinnerCommand() throws Exception {
        //given
        Consumer<Dinner> dinner = d -> System.out.printf("Having "+d+" in dinner");

        //when
        FunctionalCommandInvoker<Dinner> invoker = new FunctionalCommandInvoker<>();

        //then
        invoker.invokeCommand(dinner, new Dinner());
    }

    @Test
    public void shouldInvokeLunchCommand() throws Exception {
        //given
        Consumer<Lunch> lunch = l -> System.out.printf("Having "+l+" in lunch");

        //when
        FunctionalCommandInvoker<Lunch> invoker = new FunctionalCommandInvoker<>();

        //then
        invoker.invokeCommand(lunch, new Lunch());
    }
}