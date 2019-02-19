# Codelab 10

1. Start by creating an XML Schema that defines the element `phoneContacts`, it consists of 0, 1 or more (unbounded) `person` elements.
2. The `person` element is the same as the one you created in `codelab09`, however, it also consists of a `phoneNumber` element.
    - `phoneNumber` should have `isMobileNumber` as an attribute (which can be true or false but should have as its default value false)
    - Defining attributes is a bit tricky, therefore this sample XML Schema structure for creating one:
        ```xml
        <xs:element name="movieTitle">
            <xs:complexType>
                <xs:simpleContent>
                    <xs:extension base="xs:string">
                        <xs:attribute name="minimumViewingAge" type="xs:positiveInteger"/>
                    </xs:extension>
                </xs:simpleContent>
            </xs:complexType>
        </xs:element>
        ```
3. Create one or more valid (phoneContacts) instances (XML documents) for this XML Schema.

## Element and attribute reference

We provided a secondary solution (`phoneContacts_alternative.xsd`) that uses element and attribute reference intstead of nesting all the elements.

For large XML Schemas, referencing elements and attributes keeps the XML Schema more readable.

When you're done creating your own solution, make sure to a look at the alternative solution. 