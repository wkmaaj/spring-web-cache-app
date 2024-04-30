package org.pdbcorp.spring.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculationService {

    /**
     * Calculates the area of a circle using the formula
     * <code>A = PI * radius^2</code>.
     * <p>
     * This method is annotated as cacheable for radius values greater than 5 so
     * that such results can be more quickly retrieved after the initial method
     * invocation.
     * </p>
     *
     * @param radius
     * @return area of a circle
     */
    @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
    public double areaOfCircle(int radius) {
        log.info("Calculating the area of a circle with a radius of {}", radius);
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Multiplies the first parameter with the second parameter using the formula
     * <code>x * y</code>.
     * <p>
     * This method is annotated as cacheable.
     * </p>
     *
     * @param x
     * @param y
     * @return x times y
     */
    @Cacheable(value = "multiplyCache", keyGenerator = "multiplyKeyGenerator")
    public double multiply(int x, int y) {
        log.info("Multiplying {} with {}", x, y);
        return x * y;
    }

    @CacheEvict(cacheNames = { "areaOfCircleCache", "multiplyCache" }, allEntries = true)
    public void evictCache() {
        log.info("Evicting all cache entries...");
    }
}
