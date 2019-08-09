# Switchfully

## Additional topics and exercises

Below you'll find a list of additional topics and exercises, related to the
**Maven** module, for you to explore!

## Improve the security of your application with OWASP & Maven
The security of web applications is of the utmost importance.

The Open Web Application Security Project, opensource software community, that strives to improve the security of software. \
Every few years they release the OWASP top 10: A list of the most critical web application security risks.

It happens often that security holes are discovered in the opensource libraries we use. And hackers will not hesitate to abuse those holes.
Active opensource projects do their best to react swiftly to these vulnerability reports,
but as a developer, you have the responsibility to upgrade (and redeploy) your application as soon as a patch is available.

To detect dependencies with potential security problems (one of the top 10 risks), the OWASP community has created a tool that integrates with Maven.\
Add the following snippet to your maven pom file & run `mvn` to get your first security report:
````xml
    <profile>
        <id>dependency-checks</id>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.owasp</groupId>
                    <artifactId>dependency-check-maven</artifactId>
                    <version>5.1.0</version>
                    <executions>
                        <execution>
                            <phase>compile</phase>
                            <goals>
                                <goal>aggregate</goal>
                            </goals>
                        </execution>
                    </executions>
                    <configuration>
                        <formats>
                            <format>ALL</format>
                        </formats>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </profile>
````

`> mvn clean compile -Pdependency-checks`

References:
- https://www.owasp.org/
- https://jeremylong.github.io/DependencyCheck/
- https://www.owasp.org/index.php/Top_10-2017_A9-Using_Components_with_Known_Vulnerabilities