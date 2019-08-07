package com.quicktutorialz.nio.endponits.v1;

import com.mawashi.nio.annotations.Api;
import com.mawashi.nio.utils.Action;
import com.mawashi.nio.utils.Endpoints;
import com.quicktutorialz.nio.daos.v1.ToDoDao;
import com.quicktutorialz.nio.daos.v1.ToDoDaoImpl;
import com.quicktutorialz.nio.entities.ResponseDto;
import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.entities.ToDoDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class ToDoEndpoints extends Endpoints {

    public static final String CREATE = "/api/v1/create";
    public static final String READ_ID = "/api/v1/read/{id}";
    public static final String READ = "/api/v1/read";
    public static final String UPDATE = "/api/v1/update";
    public static final String DELETE = "/api/v1/delete/{id}";
    public static final String APPLICATION_JSON = "application/json";

    ToDoDao toDoDao = ToDoDaoImpl.getInstance();

    @Api(path = CREATE,method = "POST", consumes = APPLICATION_JSON, produces = APPLICATION_JSON, description = "")
    Action createToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        ToDoDto input =  (ToDoDto) getDataFromJsonBodyRequest(request,ToDoDto.class );
        ToDo output = toDoDao.create(input);
        toJsonResponse(request,response, new ResponseDto(200,output));
    };
    @Api(path = READ_ID, produces = APPLICATION_JSON, description = "")
    Action readToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        String id = getPathVariables(request).get("id");
        Optional<ToDo> output = toDoDao.read(id);
        toJsonResponse(request,response, new ResponseDto(200,output.isPresent() ? output.get():"todo not found!"));
    };
    @Api(path = READ, produces = APPLICATION_JSON, description = "")
    Action readAllToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        List<ToDo> output = toDoDao.readAll();
        toJsonResponse(request,response, new ResponseDto(200,output));
    };
    @Api(path = UPDATE,method = "POST", consumes = APPLICATION_JSON, produces = APPLICATION_JSON, description = "")
    Action updateToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        ToDo input =  (ToDo) getDataFromJsonBodyRequest(request,ToDo.class );
        Optional<ToDo> output = toDoDao.update(input);
        toJsonResponse(request,response, new ResponseDto(200,output.isPresent() ? output.get():"todo not update!"));
    };
    @Api(path = DELETE, produces = APPLICATION_JSON, description = "")
    Action deleteToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        String id = getPathVariables(request).get("id");
        toJsonResponse(request,response, new ResponseDto(200,toDoDao.delete(id) ?"Todo deleted": "Todo not deleted"));
    };


    public ToDoEndpoints() {
        setEndpoint(CREATE,createToDo);
        setEndpoint(READ_ID,readToDo);
        setEndpoint(READ,readAllToDo);
        setEndpoint(UPDATE,updateToDo);
        setEndpoint(DELETE,deleteToDo);
    }
}
