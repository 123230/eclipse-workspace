/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import model.Forecastprojekt;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

import com.google.inject.Singleton;


@Singleton
public class ApplicationController {

    public Result index() {

        return Results.html();

    }
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }
    
    public static class SimplePojo {

        public String content;
        
    }
    
    public Result uebersicht() {
    	//
        return Results.html();
    }
    
    public Result postforecast(
    		@PathParam("id") Integer id,
    		@PathParam("name") String name,
    		@PathParam("auftragsstatus") String auftragsstatus,
    		Forecastprojekt forecastprojekte) {    	
    	ForecastprojektController controller = new ForecastprojektController();
    	Result result = controller.getforecastprojekt();//Results.html();
    	result.render("id", Integer.toString(id));
    	result.render("name", name);
        result.render("auftragsstatus", auftragsstatus);

        return Results.html();
    }
}
