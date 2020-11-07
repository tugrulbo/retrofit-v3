package com.tugrulbo.retrofitv3.RestApi;

public class BaseManager {
        protected RestApi getRestApiClient(){
            RestApiClient restAPIClient = new RestApiClient(BaseUrl.base_url);
            return  restAPIClient.getRestApi();
        }
}
