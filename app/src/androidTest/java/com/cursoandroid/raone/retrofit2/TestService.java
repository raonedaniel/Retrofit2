package com.cursoandroid.raone.retrofit2;

import com.cursoandroid.raone.retrofit2.model.Results;

import junit.framework.TestCase;

import org.junit.Assert;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestService extends TestCase {
    public void testLondon(){
        ServiceService s = RetrofitUtil.get();
        Results results = s.geocoding("london").execute().body();
        assertEquals(40, results.results.size());

    }
}
