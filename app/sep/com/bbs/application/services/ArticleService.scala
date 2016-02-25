package sep.com.bbs.application.services

import sep.com.bbs.domain.impl.ArticleRepository
import sep.com.bbs.domain.model.article.Article
import sep.com.bbs.domain.service.ArticleDomainService
import sep.com.bbs.domain.shared.ArticleID
import sep.com.bbs.infra.dto.ArticleDTO

/**
 * fulfill Business use cases
 */
object ArticleService {

  def getListArticle():List[ArticleDTO] = {
    ArticleRepository.resolveAll().map(ar => ArticleDomainService.getDTO(ar))
  }

  def viewArticle(id: String):Option[ArticleDTO] = {
    ArticleRepository.resolveByById(ArticleID(id)) match{
      case Some(ar) => Some(ArticleDomainService.getDTO(ar))
      case _ => None
    }
  }
}
