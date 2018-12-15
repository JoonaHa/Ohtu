/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author JoonaHa
 */
public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();

    }
    
    public QueryBuilder playsIn(String team) {
        Matcher newmatcher = new PlaysIn(team);
        matcher = new And(matcher, newmatcher);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        Matcher newmatcher = new HasAtLeast(value, category);
        matcher = new And(matcher, newmatcher);
        
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category) {
        Matcher newmatcher = new HasFewerThan(value, category);
        matcher = new And(matcher, newmatcher);
        return this;
    
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matcher = new Or(m1, m2);
        return this;
    
    }
    
    

    public Matcher build() {
        Matcher oldmatcher = matcher;
        matcher = new All();
        return oldmatcher;
        
    }

}
