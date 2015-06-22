import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import net.sf.json.JSON
import spock.lang.Specification

class ArticleWebSpecification extends Specification {
    def "Connection test"() {
        setup:
        def client = new RESTClient('http://localhost:8080/')
        when:
        def resp = client.get([path: 'articles', query: [user: 'rafal']])
        then:
        with(resp) {
            status == 200
            contentType == "application/json"
        }
    }

    def "PUT the article"() {
        setup:
        def client = new RESTClient('http://localhost:8080/')
        when:
        def resp = client.put([path: 'article',
                               query: [user: 'John', content: 'test content'],
                               requestContentType : JSON ])
        then:
        with(resp) {
            status == 201
            contentType == "application/json"
        }
    }

    def "Should return 200 & the article"() {
        setup:
        def client = new RESTClient('http://localhost:8080/')
        client.put([path: 'article',
                    query: [user: 'John', content: 'test content'],
                    requestContentType : JSON ])
        when:
        def resp = client.get([path: 'articles', query: [user: 'John']])
        then:
        with(resp) {
            status == 200
            contentType == "application/json"
        }
        with(resp.data) {
            resp.data.userId.size() > 0
        }
    }

    def "Should return 404 & the exception if the article doesn't exist"() {
        setup:
        def client = new RESTClient('http://localhost:8080/')
        when:
        client.get([path: 'article', query: [id: '999999']])
        then:
        def e = thrown(HttpResponseException)
        e.message == 'Not Found' // 404
    }
}