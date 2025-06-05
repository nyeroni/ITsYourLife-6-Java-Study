package org.scoula.ex06.command;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
