package com.baoying.say.web

import spock.lang.Specification
import spock.lang.Unroll

import javax.annotation.Resource

class WebAppTest extends Specification {


    def webApp = new WebApp()

    def "sum should return param1+param2"() {

        expect:
        webApp.sum(1,1) == 2
    }



//    @Unroll
//    def "Maximum #a and #b should be #cc"(){
//
//        when:
//        def x = Math.max(a,b)
//
//        then:
//        println("start #cc"+"x="+x)
//        x == cc
//
//        where:
//        a | b || cc
//        1 | 2 || 2
//        3 | 5 || 5
//        4 | 6 || 6
//
//
//    }


//    def "sum times"(){
//
//
//        when:
//        webApp.sum(1,2)
//
//        then:
//        1 * sum(1,2) >> 3
//    }

}

