package com.quicktutorialz.nio.endponits.v2;

import com.mawashi.nio.annotations.Api;
import com.mawashi.nio.utils.Action;
import com.mawashi.nio.utils.Endpoints;
import com.quicktutorialz.nio.daos.v2.ToDoDao;
import com.quicktutorialz.nio.daos.v2.ToDoDaoImpl;
import com.quicktutorialz.nio.entities.ResponseDto;
import com.quicktutorialz.nio.entities.ToDo;
import com.quicktutorialz.nio.entities.ToDoDto;
import io.reactivex.Observable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class ToDoEndpoints extends Endpoints {

    public static final String CREATE = "/api/v2/create";
    public static final String READ_ID = "/api/v2/read/{id}";
    public static final String READ = "/api/v2/read";
    public static final String UPDATE = "/api/v2/update";
    public static final String DELETE = "/api/v2/delete/{id}";
    public static final String APPLICATION_JSON = "application/json";

    ToDoDao toDoDao = ToDoDaoImpl.getInstance();

    @Api(path = CREATE,method = "POST", consumes = APPLICATION_JSON, produces = APPLICATION_JSON, description = "")
    Action createToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        Observable.just(request)
                .map(req -> (ToDoDto) getDataFromJsonBodyRequest(request,ToDoDto.class ))
                .flatMap(input -> toDoDao.create(input))
                .subscribe(output -> toJsonResponse(request,response, new ResponseDto(200,output)));
    };
    @Api(path = READ_ID, produces = APPLICATION_JSON, description = "")
    Action readToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        Observable.just(request)
                .map(req -> getPathVariables(request).get("id"))
                .flatMap(id -> toDoDao.read(id))
                .subscribe(output -> toJsonResponse(request,response,
                        new ResponseDto(200,output.isPresent() ? output.get():"todo not found!")));
    };
    @Api(path = READ, produces = APPLICATION_JSON, description = "")
    Action readAllToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        Observable.just(request)
                .flatMap(req -> toDoDao.readAll())
                .subscribe(output -> toJsonResponse(request,response, new ResponseDto(200,output)),
                            error -> toJsonResponse(request,response, new ResponseDto(500,error)));
    };
    @Api(path = UPDATE,method = "POST", consumes = APPLICATION_JSON, produces = APPLICATION_JSON, description = "")
    Action updateToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        Observable.just(request)
                .map(req -> (ToDo) getDataFromJsonBodyRequest(request,ToDo.class ))
                .flatMap(input -> toDoDao.update(input))
                .subscribe(output -> toJsonResponse(request,response, new ResponseDto(200,output.isPresent() ? output.get():"todo not update!")));
    };
    @Api(path = DELETE, produces = APPLICATION_JSON, description = "")
    Action deleteToDo = (HttpServletRequest request, HttpServletResponse response) ->{
        Observable.just(request)
                .map(req -> getPathVariables(request).get("id"))
                .flatMap(id -> toDoDao.delete(id))
                .subscribe(output -> toJsonResponse(request,response, new ResponseDto(200,output ?"Todo deleted": "Todo not deleted")));
    };


    public ToDoEndpoints() {
        setEndpoint(CREATE,createToDo);
        setEndpoint(READ_ID,readToDo);
        setEndpoint(READ,readAllToDo);
        setEndpoint(UPDATE,updateToDo);
        setEndpoint(DELETE,deleteToDo);
    }
}
