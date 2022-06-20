package com.gitcodings.stack.spring.model.request;

/**
 * Spring can automatically convert queries into a pojo
 * <p>
 * To do this, ensure that the Pojo has {@code getters} and {@code setters} for the method
 * variables. Make sure that the naming is consistent with the variables as this is how Spring will
 * know what queries to look for
 * <p>
 * For Example: <br> {@code private String fullName;} <br> Would need:  <br> {@code public String
 * getFullName() { return fullName; }} <br> and <br> {@code public String setFullName(String
 * fullName) { this.fullName = fullName; }}
 * <p>
 * It is best practice listing your variables then have IntelliJ generate all the getters and
 * setters for you <br>
 * Right click in your class and press {@code Generate... > Getter and Setter } to do this
 */
public class HelloFavoriteRequest
{
    private String  fullName;
    private String  shape;
    private Integer number;

    public String toMessage()
    {
        StringBuilder builder = new StringBuilder();

        if (fullName != null) {
            builder.append("Hello ").append(fullName).append(".\n");
        }
        if (shape != null) {
            builder.append("Your favorite shape is ").append(shape).append(".\n");
        }
        if (number != null) {
            builder.append("Your favorite number is ").append(number);
        }

        return builder.toString();
    }

    public String getFullName()
    {
        return fullName;
    }

    public HelloFavoriteRequest setFullName(String fullName)
    {
        this.fullName = fullName;
        return this;
    }

    public String getShape()
    {
        return shape;
    }

    public HelloFavoriteRequest setShape(String shape)
    {
        this.shape = shape;
        return this;
    }

    public Integer getNumber()
    {
        return number;
    }

    public HelloFavoriteRequest setNumber(Integer number)
    {
        this.number = number;
        return this;
    }
}
